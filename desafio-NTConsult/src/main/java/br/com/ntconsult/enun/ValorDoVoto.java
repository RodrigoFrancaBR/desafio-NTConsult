package br.com.ntconsult.enun;

import java.util.Arrays;
import java.util.stream.Stream;

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
		
		Stream<ValorDoVoto> valorStream = 
				Arrays.asList(ValorDoVoto.values())
				.parallelStream()
				.filter(e -> e.getValorDoVoto().equals(valor));
		
		if (valorStream.count() > 0) {		
			return valorStream.findFirst().get();
			
		} else {
			throw new IllegalArgumentException("Valor do voto informado deve ser Sim ou Não");
		}
	}

}
