package br.com.ntconsult.domain.dto;

import java.io.Serializable;

import br.com.ntconsult.domain.Pauta;

public class PautaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String titulo;
	private String descricao;
	private int totalDeVotos;
	private int totalSim;
	private int totalNao;

	public PautaDTO() {
	}

	public PautaDTO(Pauta pauta, int totalDeVotos, int totalSim, int totalNao) {		
		this.titulo = pauta.getTitulo();
		this.descricao = pauta.getDescricao();
		this.totalDeVotos = totalDeVotos;
		this.totalSim = totalSim;
		this.totalNao = totalNao;
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

	public int getTotalDeVotos() {
		return totalDeVotos;
	}

	public void setTotalDeVotos(int totalDeVotos) {
		this.totalDeVotos = totalDeVotos;
	}

	public int getTotalSim() {
		return totalSim;
	}

	public void setTotalSim(int totalSim) {
		this.totalSim = totalSim;
	}

	public int getTotalNao() {
		return totalNao;
	}

	public void setTotalNao(int totalNao) {
		this.totalNao = totalNao;
	}

}
