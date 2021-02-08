package br.com.ntconsult.api;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.com.ntconsult.domain.dto.PautaDTO;
import br.com.ntconsult.domain.dto.VotoDTO;

public interface PautaAPI {

	ResponseEntity cadastrarPauta(PautaDTO pautaDTO);

	ResponseEntity abrirSessaoEmUmaPauta(Long pautaId, Optional<Long> duracaoSessao);

	ResponseEntity votar(Long pautaId, VotoDTO votoDTO);

}
