package com.tcc.juri.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tcc.juri.entity.RespostaEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDTO {

	private Long id;
	private String descricao;
	private Integer peso;
	
	RespostaDTO(RespostaEntity entity){
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.peso = entity.getPeso();
	}
	
	
	public static List<RespostaDTO> conveter(List<RespostaEntity> respostas) {
		return respostas.stream().map(RespostaDTO::new).collect(Collectors.toList());
	}	
}