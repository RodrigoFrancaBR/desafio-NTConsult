package br.com.ntconsult.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.exceptions.ServiceException;
import br.com.ntconsult.repository.AssociadoRepository;

@Service
public class AssociadoService {

	private AssociadoRepository repository;

	public AssociadoService(AssociadoRepository repository) {
		this.repository = repository;
	}

	public Long cadastrarAssociado(Associado associado) throws ServiceException {
		if (associado.getNome() == null || associado.getNome().trim().equals("")) {
			throw new ServiceException("Nome do associado é obrigatório!");
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

}
