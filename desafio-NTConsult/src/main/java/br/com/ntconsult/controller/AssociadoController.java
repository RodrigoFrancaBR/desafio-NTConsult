package br.com.ntconsult.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ntconsult.api.AssociadoAPI;
import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.service.AssociadoService;

@RestController
@RequestMapping(value = "/associados")
public class AssociadoController implements AssociadoAPI {
	
	private AssociadoService service;

	public AssociadoController(AssociadoService service) {
		this.service = service;
	}

	@Override
	@GetMapping
	public List<Associado> findAll() {
		return service.findAll();
	}

	@Override
	@PostMapping
	public void save(@RequestBody Associado associado) {
		service.save(associado);		
	}

}
