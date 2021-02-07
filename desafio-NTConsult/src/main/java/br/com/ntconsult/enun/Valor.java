package br.com.ntconsult.enun;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Valor {
	SIM("Sim"), NAO("Não");

	private String valor;

	private Valor(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public static Valor getValor(String valor) {
		
		Stream<Valor> valorStream = 
				Arrays.asList(Valor.values())
				.parallelStream()
				.filter(e -> e.getValor().equals(valor));
		
		if (valorStream.count() > 0) {		
			return valorStream.findFirst().get();
			
		} else {
			throw new IllegalArgumentException("Valor informado deve ser Sim ou Não");
		}
	}

}
