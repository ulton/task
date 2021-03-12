package com.go.task.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Tarefa {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String descricao;

	private LocalDateTime criacao;

	private LocalDateTime lembrete;

	private LocalDateTime conclusao;

	private String status;

	@ManyToMany
	private List<Etiqueta> etiquetas;

	@OneToOne
	private Projeto projeto;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Comentario> comentarios;

	public Tarefa() {
		setEtiquetas(new ArrayList<Etiqueta>());
		setCriacao(LocalDateTime.now());
		setStatus(Status.PENDENTE.getStatus());
	}

	private void inicializar() {
		setEtiquetas(new ArrayList<Etiqueta>());
		setCriacao(LocalDateTime.now());
		setStatus(Status.PENDENTE.getStatus());
	}

	public Tarefa(String nome, String descricao, List<Etiqueta> etiquetas) {
		inicializar();
		this.nome = nome;
		this.descricao = descricao;
		this.etiquetas = etiquetas;

	}

	public Tarefa(String nome, String descricao, List<Etiqueta> etiquetas, Projeto projeto) {
		inicializar();
		this.nome = nome;
		this.descricao = descricao;
		this.etiquetas = etiquetas;
		this.projeto = projeto;
	}

	public Tarefa concluir() {

		this.status = Status.CONCLUIDO.getStatus();
		setConclusao(LocalDateTime.now());

		return this;
	}
}
