package br.com.ntconsult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ntconsult.domain.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
	@Query("SELECT v FROM Voto v WHERE v.associado.id = :associadoId and v.pauta.id = :pautaId")
	Voto obterVotoDoAssociadoNaPauta(@Param("pautaId") Long pautaId, @Param("associadoId") Long associadoId);

}
