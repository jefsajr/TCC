package com.tcc.juri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcc.juri.entity.JogadorEntity;

@Repository
public interface JogadorRepository extends JpaRepository<JogadorEntity, Long> {
	
	Optional<JogadorEntity> findById(Long id);
	
	Optional<JogadorEntity> findByUsuarioAndSenha(String usuario, String senha);
	
	@Query("from JogadorEntity order by totalPts desc")
	List<JogadorEntity> findForPlacar();

}
