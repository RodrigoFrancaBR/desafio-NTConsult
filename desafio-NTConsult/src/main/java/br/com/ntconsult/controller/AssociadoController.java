package br.com.ntconsult.controller;

import java.net.URI;
import java.util.Collection;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ntconsult.api.AssociadoAPI;
import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.exceptions.ServiceException;
import br.com.ntconsult.service.AssociadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
@RequestMapping(path="/associados")
public class AssociadoController implements AssociadoAPI {

	final static Logger logger = LoggerFactory.getLogger(AssociadoController.class);

	private AssociadoService service;

	public AssociadoController(AssociadoService service) {
		this.service = service;
	}

	@Override
	@ApiOperation("Cadastrar um Associado")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cadastrarAssociado(@RequestBody Associado associado) {
		
		logger.info("======= AssociadoController:: inicializando cadastrarAssociado =======");
		try {

			Long associadoId = service.cadastrarAssociado(associado);

			URI uri = obterUri(associadoId);

			logger.info("======= AssociadoController:: finalizado cadastrarAssociado =======");
			return ResponseEntity.created(uri).build();

		} catch (ServiceException e) {
			
			logger.info("======= AssociadoController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= AssociadoController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao cadastrar um associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Obter um Associado")
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obterAssociadoPorId(@PathVariable("id") Long id) {
		
		logger.info("======= AssociadoController:: inicializando obterAssociadoPorId =======");
		try {

			Associado associado = service.obterAssociadoPorId(id);

			logger.info("======= AssociadoController:: finalizado obterAssociadoPorId =======");
			return ResponseEntity.ok(associado);

		} catch (ServiceException e) {
			
			logger.info("======= AssociadoController::ServiceException: " + e.getMessage() + "=======");			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= AssociadoController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter um associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Obter todos os Associados")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obterAssociados() {
		
		logger.info("======= AssociadoController:: inicializando obterAssociados =======");
		try {
			
			Collection<Associado> listaDeAssociados = service.obterAssociados();
			
			logger.info("======= AssociadoController:: finalizado obterAssociados =======");
			return ResponseEntity.ok(listaDeAssociados);
			
		} catch (ServiceException e) {
			
			logger.info("======= AssociadoController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= AssociadoController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter uma lista de Associados: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Alterar os dados de um Associado pelo Id")
	@PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alterarAssociado(@PathVariable Long id, @RequestBody Associado associado) {
		
		logger.info("======= AssociadoController:: inicializando obterAssociados =======");
		try {

			service.alterarAssociado(id, associado);
			
			logger.info("======= AssociadoController:: finalizado obterAssociados =======");
			return ResponseEntity.ok().build();

		} catch (ServiceException e) {
			
			logger.info("======= AssociadoController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= AssociadoController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao alterar um Associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Excluir um Associado")
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> excluirAssociado(@PathVariable Long id) {
		
		logger.info("======= AssociadoController:: inicializando excluirAssociado =======");
		try {
			
			service.excluirAssociado(id);
			
			logger.info("======= AssociadoController:: finalizado excluirAssociado =======");
			return ResponseEntity.ok("Associado Removido com sucesso!");
			
		} catch (ServiceException e) {
			
			logger.info("======= AssociadoController::ServiceException: " + e.getMessage() + "=======");
			return ResponseEntity.badRequest().body(e.getMessage());
			
		} catch (Exception e) {
			
			logger.info("======= AssociadoController::Exception: " + e.getMessage() + "=======");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao excluir um Associado: ".concat(e.getMessage()));
		}
	}

	private URI obterUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
