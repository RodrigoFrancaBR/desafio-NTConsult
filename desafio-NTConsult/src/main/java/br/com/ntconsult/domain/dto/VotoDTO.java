package br.com.ntconsult.domain.dto;

import java.io.Serializable;

import br.com.ntconsult.enun.ValorDoVoto;

public class VotoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long associadoId;
	private ValorDoVoto valorDoVoto;

	public VotoDTO() {
	}

	public VotoDTO(Long associadoId, ValorDoVoto valorDoVoto) {
		super();
		this.associadoId = associadoId;
		this.valorDoVoto = valorDoVoto;
	}

	public Long getAssociadoId() {
		return associadoId;
	}

	public void setAssociadoId(Long associadoId) {
		this.associadoId = associadoId;
	}

	public ValorDoVoto getValorDoVoto() {
		return valorDoVoto;
	}

	public void setValorDoVoto(ValorDoVoto valorDoVoto) {
		this.valorDoVoto = valorDoVoto;
	}

}
