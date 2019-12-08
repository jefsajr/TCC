package com.tcc.juri.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogadorLoginRequest {
	
	@NotNull
	@NotEmpty
	private String usuario;
	
	@NotNull
	@NotEmpty
	private String senha;
	
}
