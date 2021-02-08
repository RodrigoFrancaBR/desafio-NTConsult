package br.com.ntconsult.enun;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ValorDoVoto {
	SIM("Sim"), NAO("Não");

	private String valorDoVoto;

	private ValorDoVoto(String valorDoVoto) {
		this.valorDoVoto = valorDoVoto;
	}

	public String getValorDoVoto() {
		return valorDoVoto;
	}

	public static ValorDoVoto obterValorDoVotoPorUm(String valor) {
		return Arrays.asList(ValorDoVoto.values()).parallelStream().filter(e -> e.getValorDoVoto().equals(valor))
				.collect(Collectors.toList()).get(0);
	}

}
