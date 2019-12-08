package com.tcc.juri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcc.juri.dto.audiencia.AudienciaResponse;
import com.tcc.juri.entity.AudienciaEntity;

@Repository
public interface AudienciaRepository extends JpaRepository<AudienciaEntity, Long> {

	Optional<AudienciaEntity> findById(Long id);
	
	@Query("SELECT new com.tcc.juri.dto.audiencia.AudienciaResponse(a.id, a.nomeJuiz, a.tipo, a.data) from AudienciaEntity a "
		 + "order by a.data desc")
	List<AudienciaResponse>list();
}
