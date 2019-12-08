package com.tcc.juri.dto.audiencia;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tcc.juri.dto.audiencia.enums.AudienciaTipoEnum;
import com.tcc.juri.entity.AudienciaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AudienciaResponse {

	private long id;
	private String nomeJuiz;
	private String tipo;

	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	private Long pontos;
	private String completude;
	
	
	public AudienciaResponse(AudienciaEntity audienciaEntity) {
		this.id = audienciaEntity.getId();
		this.nomeJuiz = audienciaEntity.getNomeJuiz();
		this.data = audienciaEntity.getData();
		this.tipo = audienciaEntity.getTipo().getNome();
	}
	
	public AudienciaResponse(Long id, String nomeJuiz, AudienciaTipoEnum tipo, Date data){
		this.id = id;
		this.nomeJuiz = nomeJuiz;
		this.tipo = tipo.getNome();
		this.data = data;
	}
	
	public static List<AudienciaResponse> conveter(List<AudienciaEntity> audiencias) {
		
		return audiencias.stream().map(AudienciaResponse::new).collect(Collectors.toList());
	}	
	
}
