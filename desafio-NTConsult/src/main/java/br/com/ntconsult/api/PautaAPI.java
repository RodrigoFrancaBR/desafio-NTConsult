package br.com.ntconsult.api;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import br.com.ntconsult.domain.Pauta;
import br.com.ntconsult.domain.Voto;
import br.com.ntconsult.domain.dto.PautaDTO;
import br.com.ntconsult.domain.dto.VotoDTO;
import br.com.ntconsult.enun.ValorDoVoto;

public interface PautaAPI {

	ResponseEntity obterPautas();

	ResponseEntity obterPautaPorId(Long pautaId);

	ResponseEntity alterarPauta(Long id, Pauta pauta);

	ResponseEntity excluirPauta(Long id);

	ResponseEntity cadastrarPauta(PautaDTO pautaDTO);

	ResponseEntity abrirSessaoEmUmaPauta(Long pautaId, Optional<Long> duracaoSessao);

	ResponseEntity votar(Long pautaId, VotoDTO votoDTO);

	ResponseEntity obterResultadoDaVotacao(Long pautaId);

}
