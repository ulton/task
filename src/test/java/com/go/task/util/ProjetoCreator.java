package com.go.task.util;

import java.time.LocalDateTime;
import java.time.Month;

import com.go.task.model.Projeto;

public class ProjetoCreator {

	static LocalDateTime CRIACAO = LocalDateTime.of(2000, Month.JANUARY, 1, 1, 1);

	public static Projeto createProjetoToBeSaved() {
		Projeto projeto = new Projeto("Estudar Spring");
		projeto.setCriacao(CRIACAO);
		
		return projeto;
	}
	
	public static Projeto createValidProjeto() {
		Projeto projeto = new Projeto("Estudar Spring");
		projeto.setCriacao(CRIACAO);
		projeto.setId(1L);
		
		return projeto;
	}
	
	public static Projeto createValidUpdatedProjeto() {
		Projeto projeto = new Projeto("Estudar Spring com JUnit");
		projeto.setCriacao(CRIACAO);
		projeto.setId(1L);
		
		return projeto;
	}
}
