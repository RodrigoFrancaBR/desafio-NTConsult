package br.com.ntconsult.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ntconsult.domain.Sessao;
import br.com.ntconsult.repository.SessaoRepository;

@Service
public class SessaoService {

	private SessaoRepository repository;

	public SessaoService(SessaoRepository repository) {
		this.repository = repository;
	}

	public List<Sessao> findAll() {
		return repository.findAll();
	}

	public void save(Sessao entity) {
		repository.save(entity);
	}

}
