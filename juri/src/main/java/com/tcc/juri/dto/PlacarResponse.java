package com.tcc.juri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlacarResponse {

	private String nome;
	private Integer pontos;
}
