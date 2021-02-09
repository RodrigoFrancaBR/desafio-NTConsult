package br.com.ntconsult.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ntconsult.api.PautaAPI;
import br.com.ntconsult.domain.Pauta;
import br.com.ntconsult.domain.dto.PautaDTO;
import br.com.ntconsult.domain.dto.VotoDTO;
import br.com.ntconsult.exceptions.ServiceException;
import br.com.ntconsult.service.PautaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping("pautas")
public class PautaController implements PautaAPI {

	private PautaService service;

	public PautaController(PautaService service) {
		this.service = service;
	}

	@Override
	@ApiOperation("Obter todas as Pautas")
	@GetMapping
	public ResponseEntity obterPautas() {
		try {
			Collection<Pauta> listaDePautas = service.obterPautas();
			return ResponseEntity.ok(listaDePautas);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter uma lista de Pautas: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Obter uma Pauta")
	@GetMapping("/{pautaId}")
	public ResponseEntity obterPautaPorId(@PathVariable("pautaId") Long pautaId) {
		try {
			Pauta pauta = service.obterPautaPorId(pautaId);
			return ResponseEntity.ok(pauta);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter um associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Alterar os dados de uma Pauta")
	@PatchMapping("/{pautaId}")
	public ResponseEntity alterarPauta(@PathVariable("pautaId") Long pautaId, @RequestBody Pauta pauta) {
		try {
			service.alterarPauta(pautaId, pauta);
			return ResponseEntity.ok().build();

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao alterar um Associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Excluir uma Pauta")
	@DeleteMapping("/{pautaId}")
	public ResponseEntity excluirPauta(@PathVariable("pautaId") Long pautaId) {
		try {
			service.excluirPauta(pautaId);
			return ResponseEntity.ok().build();
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao excluir um Associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Cadastrar uma Pauta")
	@PostMapping
	public ResponseEntity cadastrarPauta(@RequestBody PautaDTO pautaDTO) {
		try {

			Long pautaId = service.cadastrarPauta(pautaDTO);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pautaId).toUri();
			return ResponseEntity.created(uri).build();

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao cadastrar uma pauta: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Abrir uma sessão em uma Pauta")
	@PutMapping("/{pautaId}/sessoes")
	public ResponseEntity abrirSessaoEmUmaPauta(@PathVariable("pautaId") Long pautaId,
			@RequestParam("duracao") Optional<Long> duracao) {

		try {

			Pauta pauta = service.abrirSessaoEmUmaPauta(pautaId, duracao);

			return ResponseEntity.ok(pauta);

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao abrir uma sessão em uma pauta: ".concat(e.getMessage()));
		}

	}

	@Override
	@ApiOperation("Realizar um voto em uma Pauta")
	@PostMapping("/{pautaId}/votos")
	public ResponseEntity votar(@PathVariable("pautaId") Long pautaId, @RequestBody VotoDTO votoDTO) {
		try {

			service.votar(pautaId, votoDTO);

			return ResponseEntity.ok("Voto realizado com sucesso!");

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao realizar o voto: ".concat(e.getMessage()));
		}

	}

	@Override
	@ApiOperation("Obter o Resultado da votação de uma Pauta")
	@GetMapping("/{pautaId}/votos")
	public ResponseEntity obterResultadoDaVotacao(@PathVariable("pautaId") Long pautaId) {
		try {

			PautaDTO pautaDTO = service.obterResultadoDaVotacao(pautaId);

			return ResponseEntity.ok(pautaDTO);

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter o resultado da votação: ".concat(e.getMessage()));
		}

	}
}
