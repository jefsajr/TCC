package com.tcc.juri.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jogador_resposta")
public class JogadorRespostaEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "id_jogador")
	private Long jogadorId;
	
	@Column(name = "id_resposta")
	private Long respostaId;
	
	@Column(name = "id_audiencia")
	private Long audienciaId;
	
	@Column(name = "soma_peso")
	private Integer somaPeso;
}
