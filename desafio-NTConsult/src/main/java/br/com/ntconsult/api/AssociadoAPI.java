package br.com.ntconsult.api;

import org.springframework.http.ResponseEntity;

import br.com.ntconsult.domain.Associado;

public interface AssociadoAPI {	

	ResponseEntity cadastrarAssociado(Associado Associado);

	ResponseEntity obterAssociadoPorId(Long id);
	
	ResponseEntity obterAssociados();

	ResponseEntity alterarAssociado(Long id, Associado associado);

	ResponseEntity excluirAssociado(Long id);

}
