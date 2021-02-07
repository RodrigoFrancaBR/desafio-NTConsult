package br.com.ntconsult.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ntconsult.enun.ValorDoVoto;

@Entity
@Table(name = "TB_VOTO")
public class Voto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;

	@ManyToOne
	@JoinColumn(name = "associado_id")
	private Associado associado;

	String valorDoVoto;

	public Voto() {
	}

	public Voto(Pauta pauta, Associado associado, ValorDoVoto valor) {
		this.pauta = pauta;
		this.associado = associado;
		this.valorDoVoto = valor.getValorDoVoto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public ValorDoVoto getValorDoVoto() {
		return ValorDoVoto.obterValorDoVotoPorUm(valorDoVoto);
	}

	public void setValorDoVoto(ValorDoVoto valorDoVoto) {
		this.valorDoVoto = valorDoVoto.getValorDoVoto();
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
		Voto other = (Voto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
