package com.go.task.model.input;

import java.time.LocalDateTime;

import com.go.task.model.Projeto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProjetoInput {

	private String nome;

	private LocalDateTime criacao;
	
	private Projeto projetoPai;
}
