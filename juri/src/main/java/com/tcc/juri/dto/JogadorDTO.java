package com.tcc.juri.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tcc.juri.entity.JogadorEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JogadorDTO {

	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	private int totalPts;
	
	public JogadorDTO(JogadorEntity entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.usuario = entity.getUsuario();
		this.senha =  entity.getSenha();
		this.totalPts = entity.getTotalPts();
	}
	
	public static List<JogadorDTO> conveter(List<JogadorEntity> jogadores) {
		return jogadores.stream().map(JogadorDTO::new).collect(Collectors.toList());
	}	
	
	public static JogadorEntity convert(JogadorDTO jogadorDTO) {
		JogadorEntity entity = new JogadorEntity();
		entity.setNome(jogadorDTO.getNome());
		entity.setUsuario(jogadorDTO.getUsuario());
		entity.setSenha(jogadorDTO.getSenha());
		entity.setTotalPts(jogadorDTO.getTotalPts());
		return entity;
	}
}
