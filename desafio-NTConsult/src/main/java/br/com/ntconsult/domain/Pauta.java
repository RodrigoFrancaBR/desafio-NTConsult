package br.com.ntconsult.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ntconsult.domain.dto.PautaDTO;

@Entity
@Table(name = "TB_PAUTA")
public class Pauta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String descricao;

	@Column(name = "dt_abertura_sessao")
	private LocalDateTime dataDeAberturaSessao;

	@Column(name = "qt_duracao_sessao")
	private Long duracaoSessao;

	public Pauta() {
	}

	public Pauta(Long id, String titulo, String descricao, LocalDateTime dataDeAberturaSessao, Long duracaoSessao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataDeAberturaSessao = dataDeAberturaSessao;
		this.duracaoSessao = duracaoSessao;
	}

	public Pauta(PautaDTO pautaDTO) {
		this.titulo = pautaDTO.getTitulo();
		this.descricao = pautaDTO.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getDataDeAberturaSessao() {
		return dataDeAberturaSessao;
	}

	public void setDataDeAberturaSessao(LocalDateTime dataDeAberturaSessao) {
		this.dataDeAberturaSessao = dataDeAberturaSessao;
	}

	public Long getDuracaoSessao() {
		return duracaoSessao;
	}

	public void setDuracaoSessao(Long duracaoSessao) {
		this.duracaoSessao = duracaoSessao;
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
		Pauta other = (Pauta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pauta [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dataDeAberturaSessao="
				+ dataDeAberturaSessao + ", duracaoSessao=" + duracaoSessao + "]";
	}

}
