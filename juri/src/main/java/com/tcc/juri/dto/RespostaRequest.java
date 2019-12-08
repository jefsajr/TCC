package com.tcc.juri.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespostaRequest {
	
	@NotNull
	private Long idAudiencia;
		
	@NotNull
	private Long idResposta;
	
	@NotNull
	private Long idJogador;
}
