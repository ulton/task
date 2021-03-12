package com.go.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.go.task.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
