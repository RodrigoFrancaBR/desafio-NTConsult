package br.com.ntconsult.api;

import java.util.List;

import br.com.ntconsult.domain.Associado;

public interface AssociadoAPI {
	List<Associado> findAll();

	void save(Associado associado);
}
