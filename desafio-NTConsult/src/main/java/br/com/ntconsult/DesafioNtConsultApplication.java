package br.com.ntconsult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioNtConsultApplication {
	final static Logger logger = LoggerFactory.getLogger(DesafioNtConsultApplication.class);
	public static void main(String[] args) {
		logger.info("======= Iniciando DesafioNtConsultApplication::main =======");
		SpringApplication.run(DesafioNtConsultApplication.class, args);
		logger.info("======= Iniciado DesafioNtConsultApplication::main =======");
	}

}
