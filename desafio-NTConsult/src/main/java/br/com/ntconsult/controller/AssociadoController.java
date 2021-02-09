package br.com.ntconsult.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.HttpStatus;
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
@RequestMapping("/associados")
public class AssociadoController implements AssociadoAPI {

	private AssociadoService service;

	public AssociadoController(AssociadoService service) {
		this.service = service;
	}

	@Override
	@ApiOperation("Cadastrar um Associado")
	@PostMapping
	public ResponseEntity cadastrarAssociado(@RequestBody Associado Associado) {
		try {

			Associado associado = service.cadastrarAssociado(Associado);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(associado.getId())
					.toUri();
			return ResponseEntity.created(uri).body(associado);

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao cadastrar um associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Obter um Associado")
	@GetMapping("/{id}")
	public ResponseEntity obterAssociadoPorId(@PathVariable("id") Long id) {
		try {

			Associado associado = service.obterAssociadoPorId(id);

			return ResponseEntity.ok(associado);

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter um associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Obter todos os Associados")
	@GetMapping
	public ResponseEntity obterAssociados() {
		try {
			Collection<Associado> listaDeAssociados = service.obterAssociados();
			return ResponseEntity.ok(listaDeAssociados);
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao obter uma lista de Associados: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Alterar os dados de um Associado pelo Id")
	@PatchMapping("/{id}")
	public ResponseEntity alterarAssociado(@PathVariable Long id, @RequestBody Associado associado) {
		try {

			Associado associadoAlterado = service.alterarAssociado(id, associado);
			return ResponseEntity.ok(associadoAlterado);

		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao alterar um Associado: ".concat(e.getMessage()));
		}
	}

	@Override
	@ApiOperation("Excluir um Associado")
	@DeleteMapping("/{id}")
	public ResponseEntity excluirAssociado(@PathVariable Long id) {
		try {
			service.excluirAssociado(id);
			return ResponseEntity.ok("Associado Removido com sucesso!");
		} catch (ServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ocorreu algum erro ao excluir um Associado: ".concat(e.getMessage()));
		}
	}

}
