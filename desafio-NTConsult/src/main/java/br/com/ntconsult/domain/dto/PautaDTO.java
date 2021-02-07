package br.com.ntconsult.domain.dto;

import java.io.Serializable;

public class PautaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String descricao;

	public PautaDTO() {
	}

	public PautaDTO(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
