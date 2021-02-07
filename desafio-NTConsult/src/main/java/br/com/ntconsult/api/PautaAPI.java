package br.com.ntconsult.api;

import java.util.Collection;

import br.com.ntconsult.domain.Pauta;
import br.com.ntconsult.domain.dto.PautaDTO;
import br.com.ntconsult.domain.dto.VotoDTO;

public interface PautaAPI {

	Collection<Pauta> obterPautas();

	void cadastrarPauta(PautaDTO pautaDTO);

	void abrirSessaoEmUmaPauta(Long pautaId, Long duracaoSessao);

	void votar(Long pautaId, VotoDTO votoDTO);

	Pauta obterPautaPorId(Long id);	

}
