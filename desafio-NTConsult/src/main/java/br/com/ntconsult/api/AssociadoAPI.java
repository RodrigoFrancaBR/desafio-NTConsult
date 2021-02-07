package br.com.ntconsult.api;

import java.util.Collection;

import br.com.ntconsult.domain.Associado;

public interface AssociadoAPI {

	Collection<Associado> obterAssociados();

	void cadastrarAssociado(Associado Associado);	

	Associado obterAssociadoPorId(Long id);

	void alterarAssociado(Long id, Associado Associado);

	void excluirAssociado(Long id);

}
