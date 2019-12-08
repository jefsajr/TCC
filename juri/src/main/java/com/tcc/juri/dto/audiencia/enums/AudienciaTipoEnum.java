package com.tcc.juri.dto.audiencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AudienciaTipoEnum {
	EM_ANDAMENTO("Em Andamento"),
	CONCLUIDA("Concluida"),
	FECHADA("Fechada");
	
	private String nome;
	
}
