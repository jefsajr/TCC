package com.tcc.juri.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.tcc.juri.dto.audiencia.enums.AudienciaTipoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audiencia")
public class AudienciaEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nome_juiz")
	private String nomeJuiz;
	
	@Column(name = "data")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private Date data;	
	
	@Column(name = "tipo")
	private AudienciaTipoEnum tipo;
	
	
}
