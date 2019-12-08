package com.tcc.juri.dto.audiencia;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tcc.juri.dto.audiencia.enums.AudienciaTipoEnum;
import com.tcc.juri.entity.AudienciaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AudienciaDTO {

	private long id;
	
	@NotNull
	@NotEmpty
	private String nomeJuiz;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	
	private String tipo;
	
	public AudienciaDTO(AudienciaEntity audienciaEntity) {
		this.id = audienciaEntity.getId();
		this.nomeJuiz = audienciaEntity.getNomeJuiz();
		this.data = audienciaEntity.getData();
		this.tipo = audienciaEntity.getTipo().getNome();
	}
	
	public static List<AudienciaDTO> conveter(List<AudienciaEntity> audiencias) {
		
		return audiencias.stream().map(AudienciaDTO::new).collect(Collectors.toList());
	}	
	
	public static AudienciaEntity convert(AudienciaDTO audienciaDTO) {
		AudienciaEntity audienciaEntity = new AudienciaEntity();
		audienciaEntity.setNomeJuiz(audienciaDTO.getNomeJuiz());
		audienciaEntity.setData(new Date());
		audienciaEntity.setTipo(AudienciaTipoEnum.EM_ANDAMENTO);
		return audienciaEntity;
		
	}
}
