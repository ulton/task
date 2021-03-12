package com.go.task.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Projeto {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private LocalDateTime criacao;

	@OneToOne
	private Projeto projetoPai;

	public Projeto() {
	}

	public Projeto(String nome) {
		if (this.criacao == null)
			setCriacao(LocalDateTime.now());

		this.nome = nome;
	}
}
