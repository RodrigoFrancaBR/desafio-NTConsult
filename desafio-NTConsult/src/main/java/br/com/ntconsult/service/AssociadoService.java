package br.com.ntconsult.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.repository.AssociadoRepository;

@Service
public class AssociadoService {

	private AssociadoRepository repository;

	public AssociadoService(AssociadoRepository repository) {
		this.repository = repository;
	}
	
	public List<Associado> findAll() {
		return repository.findAll();
	}
	
	public void save(Associado entity) {
		repository.save(entity);
	}

	
}
