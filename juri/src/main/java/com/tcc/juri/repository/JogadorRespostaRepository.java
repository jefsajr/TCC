package com.tcc.juri.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcc.juri.dto.audiencia.EstatisticasResposta;
import com.tcc.juri.entity.JogadorRespostaEntity;

@Repository
public interface JogadorRespostaRepository extends JpaRepository<JogadorRespostaEntity, Long>{

	Optional<JogadorRespostaEntity> findById(Long id);
	
	Optional<JogadorRespostaEntity> findByJogadorIdAndRespostaIdAndAudienciaId(Long jogadorId, Long respostaId, Long audienciaId);
	
	@Query("select new com.tcc.juri.dto.audiencia.EstatisticasResposta(count(r.id), sum(r.somaPeso)) from JogadorRespostaEntity r where r.audienciaId = :audienciaId")
	EstatisticasResposta findEstatisticaByAudienciaId(@Param("audienciaId") Long audienciaId);
	
}
