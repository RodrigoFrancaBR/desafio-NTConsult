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

	Voto obterVotoDoAssociadoNaPauta(Long pautaId, Long associadoId) {
		return this.repository.obterVotoDoAssociadoNaPauta(pautaId, associadoId);
	}

	public void realizarVoto(Voto voto) {
		repository.save(voto);
	}

	public List<Voto> obterResultadoDaVotacao(Long pautaId) {
		return repository.obterResultadoDaVotacaoPor(pautaId);
	}
}
