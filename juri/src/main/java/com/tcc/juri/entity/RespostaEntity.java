package com.tcc.juri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "resposta")
public class RespostaEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "id_pergunta")
	private Long perguntaId;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "peso")
	private Integer peso;
}
