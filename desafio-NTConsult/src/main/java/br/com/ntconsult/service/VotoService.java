package br.com.ntconsult.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ntconsult.domain.Voto;
import br.com.ntconsult.repository.VotoRepository;

@Service
public class VotoService {

	private VotoRepository repository;

	public VotoService(VotoRepository repository) {
		this.repository = repository;
	}

	public boolean podeVotarNessaPauta(Long pautaId, Long associadoId) {
		Voto voto = this.obterVotoDoAssociadoNaPauta(pautaId, associadoId);
		return (voto == null) ? true : false;
	}

	public void realizarVoto(Voto voto) {
		repository.save(voto);
	}

	public List<Voto> obterResultadoDaVotacao(Long pautaId) {
		return repository.obterResultadoDaVotacaoPor(pautaId);
	}

	public Voto obterVotoDoAssociadoNaPauta(Long pautaId, Long associadoId) {
		return repository.obterVotoDoAssociadoNaPauta(pautaId, associadoId);
	}

}
