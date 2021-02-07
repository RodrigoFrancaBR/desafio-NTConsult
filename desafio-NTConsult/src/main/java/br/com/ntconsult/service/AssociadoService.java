package br.com.ntconsult.service;

import org.springframework.stereotype.Service;

import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.repository.AssociadoRepository;
@Service
public class AssociadoService {
	
	private AssociadoRepository repository;

	public AssociadoService(AssociadoRepository repository) {
		this.repository = repository;
	}

	public void cadastrarAssociado(Associado associado) {
		repository.save(associado);		
	}

}
