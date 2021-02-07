package br.com.ntconsult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.domain.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {
	
}
