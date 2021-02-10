package br.com.ntconsult.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.domain.dto.AssociadoDTO;
import br.com.ntconsult.enun.StatusCPF;
import br.com.ntconsult.exceptions.ServiceException;
import br.com.ntconsult.repository.AssociadoRepository;

@Service
public class AssociadoService {
	final static Logger logger = LoggerFactory.getLogger(AssociadoService.class);

	private AssociadoRepository repository;
	private WebClient webClient;

	public AssociadoService(AssociadoRepository repository, WebClient webClient) {
		this.repository = repository;
		this.webClient = webClient;
	}

	public Long cadastrarAssociado(Associado associado) throws ServiceException {

		if (associado.getCpf() == null || associado.getCpf().trim().equals("")) {
			throw new ServiceException("CPF do associado é obrigatório!");
		}

		return repository.save(associado).getId();

	}

	public Associado obterAssociadoPorId(Long id) throws ServiceException {

		Optional<Associado> associado = repository.findById(id);

		if (associado.isPresent()) {
			return associado.get();
		} else {
			throw new ServiceException("Nenhum Associado encontrado com o id informado: " + id);
		}
	}

	public Associado obterAssociadoPorCPF(String cpf) {
		return repository.findByCpf(cpf);			
	}



	public Collection<Associado> obterAssociados() throws ServiceException {

		List<Associado> listaDeAssociados = repository.findAll();

		if (listaDeAssociados.size() > 0) {
			return listaDeAssociados;
		} else {
			throw new ServiceException("Nenhum Associado encontrado no momento");
		}
	}

	public void alterarAssociado(Long id, Associado associado) throws ServiceException {

		Associado associadoEncontrado = obterAssociadoPorId(id);
		associadoEncontrado.setNome(associado.getNome());
		repository.save(associadoEncontrado);
	}

	public void excluirAssociado(Long id) throws ServiceException {

		Associado associadoEncontrado = obterAssociadoPorId(id);
		repository.delete(associadoEncontrado);
	}

	public boolean cpfValido(String cpf) {

		AssociadoDTO associadoDTO = this.getStatusCpf(cpf);

		if (associadoDTO.getStatus().equals(StatusCPF.ABLE_TO_VOTE)) {
			return true;
		} else {
			return false;
		}
	}

	private AssociadoDTO getStatusCpf(String cpf) {
		return this.webClient
				.method(HttpMethod.GET)
				.uri("/users/{cpf}", cpf)
				.retrieve()
				.bodyToMono(AssociadoDTO.class)
				.block();
	}
}