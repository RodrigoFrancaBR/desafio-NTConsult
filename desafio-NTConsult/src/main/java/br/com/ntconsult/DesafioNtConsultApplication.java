package br.com.ntconsult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.common.net.HttpHeaders;

@SpringBootApplication
public class DesafioNtConsultApplication {

	final static Logger logger = LoggerFactory.getLogger(DesafioNtConsultApplication.class);

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder
				.baseUrl("https://user-info.herokuapp.com")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	public static void main(String[] args) {

		logger.info("======= Iniciando DesafioNtConsultApplication::main =======");

		SpringApplication.run(DesafioNtConsultApplication.class, args);

		logger.info("======= Iniciado DesafioNtConsultApplication::main =======");

	}

}
