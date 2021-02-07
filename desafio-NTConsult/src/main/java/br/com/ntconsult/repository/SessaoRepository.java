package br.com.ntconsult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

}
