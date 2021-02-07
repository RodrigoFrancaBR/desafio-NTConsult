package br.com.ntconsult.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Sessao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String pauta;
	private LocalDateTime dataDeAbertura;
	private int duracao;

	public Sessao() {
	}

	public Sessao(Long id, String pauta, LocalDateTime dataDeAbertura, int duracao) {
		super();
		this.id = id;
		this.pauta = pauta;
		this.dataDeAbertura = dataDeAbertura;
		this.duracao = duracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPauta() {
		return pauta;
	}

	public void setPauta(String pauta) {
		this.pauta = pauta;
	}

	public LocalDateTime getDataDeAbertura() {
		return dataDeAbertura;
	}

	public void setDataDeAbertura(LocalDateTime dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sessao other = (Sessao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
