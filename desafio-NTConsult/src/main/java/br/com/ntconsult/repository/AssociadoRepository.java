package br.com.ntconsult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.domain.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {

}
