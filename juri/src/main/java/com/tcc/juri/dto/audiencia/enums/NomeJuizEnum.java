package com.tcc.juri.dto.audiencia.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lombok.Getter;

@Getter
public enum NomeJuizEnum {
	JUIZ_1("José Amancio Ribeiro"),
	JUIZ_2("Lierte Sobrinho Queiroz"),
	JUIZ_3("Fabío Melo Faria"),
	JUIZ_4("Agenor Melo Siqueira"),
	JUIZ_5("Pedro Rúbio Marthis");
	
	private String nome;
	
	 private static final List<NomeJuizEnum> VALUES =
	    Collections.unmodifiableList(Arrays.asList(values()));
	  private static final int SIZE = VALUES.size();
	  private static final Random RANDOM = new Random();
	
	NomeJuizEnum(String nome) {
		this.nome = nome;
	}
	
	public static String generateNome() {
		 return VALUES.get(RANDOM.nextInt(SIZE)).getNome();
	}
}
