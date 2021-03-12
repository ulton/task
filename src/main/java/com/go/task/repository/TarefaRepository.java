package com.go.task.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.go.task.model.Projeto;
import com.go.task.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

	List<Tarefa> findByLembreteBetween(LocalDateTime dataDe, LocalDateTime dataAte);

	List<Tarefa> findByProjeto(Projeto projeto);

}
