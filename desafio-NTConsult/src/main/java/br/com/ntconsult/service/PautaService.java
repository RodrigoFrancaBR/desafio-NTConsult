package br.com.ntconsult.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.domain.Pauta;
import br.com.ntconsult.domain.Voto;
import br.com.ntconsult.domain.dto.PautaDTO;
import br.com.ntconsult.domain.dto.VotoDTO;
import br.com.ntconsult.exceptions.ServiceException;
import br.com.ntconsult.repository.PautaRepository;

@Service
public class PautaService {

	private PautaRepository pautaRepository;
	private AssociadoService associadoService;
	private VotoService votoService;

	public PautaService(PautaRepository pautaRepository, AssociadoService associadoService, VotoService votoService) {

		this.pautaRepository = pautaRepository;
		this.associadoService = associadoService;
		this.votoService = votoService;

	}

	public PautaDTO cadastrarPauta(PautaDTO pautaDTO) throws ServiceException {

		if (pautaDTO.getDescricao() == null || pautaDTO.getDescricao().trim().equals("")) {
			throw new ServiceException("A descrição de uma pauta é obrigatório!");
		}

		Pauta pauta = new Pauta(pautaDTO);
		Pauta pautaSalva = pautaRepository.save(pauta);

		return new PautaDTO(pautaSalva.getId(), pautaSalva.getTitulo(), pautaSalva.getDescricao());
	}

	public Pauta abrirSessaoEmUmaPauta(Long pautaId, Optional<Long> duracaoSessao) throws ServiceException {

		Pauta pauta = obterPautaPorId(pautaId);

		if (duracaoSessao.isPresent()) {
			pauta.setDuracaoSessao(duracaoSessao.get());
		} else {
			pauta.setDuracaoSessao(1l);
		}

		pauta.setDataDeAberturaSessao(LocalDateTime.now());

		return pautaRepository.save(pauta);

	}

	public void votar(Long pautaId, VotoDTO votoDTO) throws ServiceException {

		Pauta pauta = obterPautaPorId(pautaId);

		Associado associado = associadoService.obterAssociadoPorId(votoDTO.getAssociadoId());

		if (!podeVotarNessaPauta(pauta.getId(), associado.getId())) {
			throw new ServiceException("Associado: " + associado.getId() + " já votou na sessao: " + pauta.getId());
		}

		Voto voto = new Voto(pauta, associado, votoDTO.getValorDoVoto());

		if (sessaoEstaAberta(pauta)) {
			votoService.realizarVoto(voto);
		} else {
			throw new ServiceException("A Sessao já está Encerrada");
		}
	}

	public PautaDTO obterResultadoDaVotacaoPor(Long pautaId) throws ServiceException {
		Pauta pauta = obterPautaPorId(pautaId);

		List<Voto> listaDeVotosPorPautaId = votoService.obterResultadoDaVotacaoPor(pautaId);

		int totalDeVotos = listaDeVotosPorPautaId.size();
		int totalDeVotosSIM = 0;
		int totalDeVotosNAO = 0;
		
		for (Voto voto : listaDeVotosPorPautaId) {
			if (voto.getValorDoVoto().getValorDoVoto().equals("Sim")) {
				totalDeVotosSIM +=1;
			}else {
				totalDeVotosNAO +=1;
			}
		}

		return new PautaDTO(pauta, totalDeVotos, totalDeVotosSIM, totalDeVotosNAO);
	}

	public Collection<Pauta> obterPautas() {
		return this.pautaRepository.findAll();
	}

	public Pauta obterPautaPorId(Long id) throws ServiceException {
		Optional<Pauta> pauta = pautaRepository.findById(id);
		if (pauta.isPresent()) {
			return pauta.get();
		} else {
			throw new ServiceException("Nenhuma Pauta encontrada com o id informado: " + id);
		}
	}

	private boolean podeVotarNessaPauta(Long pautaId, Long associadoId) {
		Voto voto = votoService.obterVotoDoAssociadoNaPauta(pautaId, associadoId);
		if (voto == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean sessaoEstaAberta(Pauta pauta) {

		LocalDateTime dataAberturaSessao = pauta.getDataDeAberturaSessao();
		LocalDateTime dataEncerramentoSessao = dataAberturaSessao.plusMinutes(pauta.getDuracaoSessao());
		LocalDateTime dataVotacao = LocalDateTime.now();

		if ((dataVotacao.isAfter(dataAberturaSessao) || dataVotacao.isEqual(dataAberturaSessao))
				&& (dataVotacao.isBefore(dataEncerramentoSessao) || dataVotacao.isEqual(dataEncerramentoSessao))) {
			return true;
		} else {
			return false;
		}
	}

}
