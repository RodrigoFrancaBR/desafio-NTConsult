package br.com.ntconsult.controller;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping(path="pautas")
public class PautaController implements PautaAPI {	
	
	final static Logger logger = LoggerFactory.getLogger(PautaController.class);

	private PautaService service;
	
	public PautaController(PautaService service) {
		this.service = service;
	}
	
	@Override
	@ApiOperation("Obter todas as Pautas")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obterPautas() {
		
		logger.info("======= PautaController:: inicializando obterPautas =======");		
		try {
			
			Collection<Pauta> listaDePautas = service.obterPautas();
			
			logger.info("======= PautaController:: finalizado obterPautas =======");
			return ResponseEntity.ok(listaDePautas);
			
		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= PautaController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter uma lista de Pautas: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Obter uma Pauta")
	@GetMapping(path = "/{pautaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obterPautaPorId(@PathVariable("pautaId") Long pautaId) {

		logger.info("======= PautaController:: inicializando obterPautaPorId =======");		
		try {
		
			Pauta pauta = service.obterPautaPorId(pautaId);
			
			logger.info("======= PautaController:: finalizado obterPautaPorId =======");
			return ResponseEntity.ok(pauta);
			
		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= PautaController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter um associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Alterar os dados de uma Pauta")
	@PatchMapping(path="/{pautaId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alterarPauta(
			@PathVariable("pautaId") Long pautaId,
			@RequestBody Pauta pauta) {
		
		logger.info("======= PautaController:: inicializando alterarPauta =======");
		try {
			
			service.alterarPauta(pautaId, pauta);
			
			logger.info("======= PautaController:: finalizado alterarPauta =======");
			return ResponseEntity.ok().build();

		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao alterar um Associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Excluir uma Pauta")
	@DeleteMapping(path="/{pautaId}")
	public ResponseEntity<?> excluirPauta(@PathVariable("pautaId") Long pautaId) {
		
		logger.info("======= PautaController:: inicializando excluirPauta =======");
		try {
			
			service.excluirPauta(pautaId);
			
			logger.info("======= PautaController:: finalizado excluirPauta =======");
			return ResponseEntity.ok().build();
			
		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= PautaController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao excluir um Associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Cadastrar uma Pauta")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cadastrarPauta(@RequestBody PautaDTO pautaDTO) {
		
		logger.info("======= PautaController:: inicializando cadastrarPauta =======");
		try {

			Long pautaId = service.cadastrarPauta(pautaDTO);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pautaId).toUri();
			
			logger.info("======= PautaController:: finalizado cadastrarPauta =======");
			return ResponseEntity.created(uri).build();

		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= PautaController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao cadastrar uma pauta: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Abrir uma sessão em uma Pauta")
	@PutMapping(path="/{pautaId}/sessoes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> abrirSessaoEmUmaPauta(
			@PathVariable("pautaId") Long pautaId,
			@RequestParam("duracao") Optional<Long> duracao) {
		
		logger.info("======= PautaController:: inicializando abrirSessaoEmUmaPauta =======");
		try {

			Pauta pauta = service.abrirSessaoEmUmaPauta(pautaId, duracao);
			
			logger.info("======= PautaController:: finalizado abrirSessaoEmUmaPauta =======");
			return ResponseEntity.ok(pauta);

		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			
			logger.info("======= PautaController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao abrir uma sessão em uma pauta: ".concat(e.getMessage()));
		}

	}

	@Override
	@ApiOperation("Realizar um voto em uma Pauta")
	@PostMapping(path="/{pautaId}/votos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> votar(
			@PathVariable("pautaId") Long pautaId,
			@RequestBody VotoDTO votoDTO) {
		
		logger.info("======= PautaController:: inicializando votar =======");
		try {

			service.votar(pautaId, votoDTO);
			
			logger.info("======= PautaController:: finalizado votar =======");
			return ResponseEntity.ok().build();

		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= PautaController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao realizar o voto: ".concat(e.getMessage()));
		}

	}
	

	@Override
	@ApiOperation("Obter o Resultado da votação de uma Pauta")
	@GetMapping(path="/{pautaId}/votos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obterResultadoDaVotacao(@PathVariable("pautaId") Long pautaId) {
		
		logger.info("======= PautaController:: inicializando obterResultadoDaVotacao =======");
		try {

			PautaDTO pautaDTO = service.obterResultadoDaVotacao(pautaId);
			
			logger.info("======= PautaController:: finalizado obterResultadoDaVotacao =======");
			return ResponseEntity.ok(pautaDTO);

		} catch (ServiceException e) {
			
			logger.info("======= PautaController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= PautaController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter o resultado da votação: ".concat(e.getMessage()));
		}

	}
}
