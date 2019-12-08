package com.tcc.juri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.juri.entity.RespostaEntity;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaEntity, Long> {

	Optional<RespostaEntity> findById(Long id);
	
	List<RespostaEntity> findByPerguntaId(Long perguntaId);
}
