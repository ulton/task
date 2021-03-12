package com.go.task.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Comentario {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;

	private LocalDateTime criacao;

	private LocalDateTime edicao;

	public Comentario() {
	}

	public Comentario(String descricao) {
		this.descricao = descricao;
		if (this.criacao == null)
			this.criacao = LocalDateTime.now();
	}
}
