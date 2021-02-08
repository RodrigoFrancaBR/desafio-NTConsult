package br.com.ntconsult.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ntconsult.api.PautaAPI;
import br.com.ntconsult.domain.Pauta;
import br.com.ntconsult.domain.dto.PautaDTO;
import br.com.ntconsult.domain.dto.VotoDTO;
import br.com.ntconsult.service.PautaService;

@RestController
@RequestMapping(value = "/pautas")
public class PautaController implements PautaAPI {

	private PautaService service;

	public PautaController(PautaService service) {
		this.service = service;
	}

	@Override
	@PostMapping
	public void cadastrarPauta(@RequestBody PautaDTO pautaDTO) {
		service.cadastrarPauta(pautaDTO);
	}

	@Override
	@PutMapping(value = {"/{pautaId}/sessoes", "/{duracaoSessao}"})
	public void abrirSessaoEmUmaPauta(
			@PathVariable(name = "pautaId", required = true) Long pautaId,
			@PathVariable(name ="duracaoSessao", required = false) Optional<Long> duracaoSessao) {
		
		try {
			service.abrirSessaoEmUmaPauta(pautaId, duracaoSessao);	
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

	@Override
	@PostMapping(value = "/{pautaId}/votos")
	public void votar(@PathVariable("pautaId") Long pautaId, @RequestBody VotoDTO votoDTO) {
		service.votar(pautaId, votoDTO);
	}

	@Override
	public Collection<Pauta> obterPautas() {
		return service.obterPautas();
	}

	@Override
	public Pauta obterPautaPorId(Long id) {
		return service.obterPautaPorId(id);
	}

}
