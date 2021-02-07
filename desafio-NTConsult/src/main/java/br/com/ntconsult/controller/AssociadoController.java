package br.com.ntconsult.controller;

import java.util.Collection;

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
	@PostMapping
	public void cadastrarAssociado(@RequestBody Associado Associado) {
		service.cadastrarAssociado(Associado);
	}

	@Override
	public Collection<Associado> obterAssociados() {
		
		return null;
	}

	@Override
	public Associado obterAssociadoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterarAssociado(Long id, Associado Associado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluirAssociado(Long id) {
		// TODO Auto-generated method stub
		
	}

	


}
