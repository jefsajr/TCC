package com.tcc.juri.dto;

import com.tcc.juri.entity.JogadorEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JogadorResponse {

	private long id;
	
	private String nome;
	
	private Integer totalPontos;
	
	public JogadorResponse(JogadorEntity entity){
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.totalPontos = entity.getTotalPts();
	}
	
}
