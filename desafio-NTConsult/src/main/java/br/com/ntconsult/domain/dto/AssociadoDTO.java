package br.com.ntconsult.domain.dto;

import java.io.Serializable;

import br.com.ntconsult.enun.StatusCPF;
import br.com.ntconsult.enun.ValorDoVoto;

public class AssociadoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cpf;
	private ValorDoVoto valorDoVoto;
	private StatusCPF status;

	public AssociadoDTO() {

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public ValorDoVoto getValorDoVoto() {
		return valorDoVoto;
	}

	public void setValorDoVoto(ValorDoVoto valorDoVoto) {
		this.valorDoVoto = valorDoVoto;
	}

	public StatusCPF getStatus() {
		return status;
	}

	public void setStatus(StatusCPF status) {
		this.status = status;
	}

}
