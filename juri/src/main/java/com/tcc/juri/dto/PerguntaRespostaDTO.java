package com.tcc.juri.dto;

import java.util.List;

import com.tcc.juri.entity.PerguntaEntity;
import com.tcc.juri.entity.RespostaEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerguntaRespostaDTO {
	
	private Long id;
	private String descircao;
	private List<RespostaDTO> respostas;
	
	public PerguntaRespostaDTO(PerguntaEntity pergunta, List<RespostaEntity> respostas) {
		this.id = pergunta.getId();
		this.descircao = pergunta.getDescricao();
		this.respostas = RespostaDTO.conveter(respostas);
	}
}
