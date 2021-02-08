package br.com.ntconsult.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.domain.Pauta;
import br.com.ntconsult.domain.Voto;
import br.com.ntconsult.domain.dto.PautaDTO;
import br.com.ntconsult.domain.dto.VotoDTO;
import br.com.ntconsult.repository.AssociadoRepository;
import br.com.ntconsult.repository.PautaRepository;
import br.com.ntconsult.repository.VotoRepository;

@Service
public class PautaService {

	private PautaRepository pautaRepository;
	private AssociadoRepository associadoRepository;
	private VotoRepository votoRepository;

	public PautaService(PautaRepository pautaRepository, AssociadoRepository associadoRepository,
			VotoRepository votoRepository) {

		this.pautaRepository = pautaRepository;
		this.associadoRepository = associadoRepository;
		this.votoRepository = votoRepository;

	}

	public void cadastrarPauta(PautaDTO pautaDTO) {
		Pauta pauta = new Pauta(pautaDTO);
		pautaRepository.save(pauta);
	}

	public void abrirSessaoEmUmaPauta(Long pautaId, Optional<Long> duracaoSessao) throws Exception {
		Pauta pauta = obterPautaPorId(pautaId);
		
		if (pauta != null) {
		
			if (duracaoSessao.isPresent()) {
				pauta.setDuracaoSessao(duracaoSessao.get());	
			}else {
				pauta.setDuracaoSessao(1l);
			}
			
			pauta.setDataDeAberturaSessao(LocalDateTime.now());
			pautaRepository.save(pauta);
			
		}else {
			throw new Exception("Pauta não encontrada");
		}

	}

	public void votar(Long pautaId, VotoDTO votoDTO) {
		Pauta pauta = obterPautaPorId(pautaId);
		Optional<Associado> associado = associadoRepository.findById(votoDTO.getAssociadoId());

		if (pauta != null && associado.isPresent()) {
			Voto voto = new Voto(pauta, associado.get(), votoDTO.getValorDoVoto());
			votoRepository.save(voto);
		}
	}

	public Collection<Pauta> obterPautas() {
		return this.pautaRepository.findAll();
	}

	public Pauta obterPautaPorId(Long id) {
		Optional<Pauta> pautaOptional = pautaRepository.findById(id);

		if (pautaOptional.isPresent()) {
			return pautaOptional.get();
		} else {
			return null;
		}
	}

}
