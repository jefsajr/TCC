package com.tcc.juri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tcc.juri.entity.PerguntaEntity;

@Repository
public interface PerguntaRepository extends JpaRepository<PerguntaEntity, Long> {

	Optional<PerguntaEntity> findById(Long id);
	
	@Query("select count(p) from PerguntaEntity p")
	Long countPerguntas();
	
	@Query("from PerguntaEntity p where "
			+ "p.id not in ("
			+ "select res.perguntaId from JogadorRespostaEntity jr, "
			+ "RespostaEntity res where res.id = jr.respostaId and jr.audienciaId = :id)")
	List<PerguntaEntity> findNotUsedTerminalByIdAudiencia(@Param("id") Long id);
}
