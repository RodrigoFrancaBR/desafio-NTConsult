package br.com.ntconsult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.domain.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

}
