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

	public List<Voto> findAll() {
		return repository.findAll();
	}

	public void save(Voto entity) {
		repository.save(entity);
	}

}
