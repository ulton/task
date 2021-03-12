package com.go.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.task.model.Tarefa;
import com.go.task.service.TarefaService;

@RestController
@RequestMapping("/adicionais")
public class Adicionais {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping("/hoje")
	public ResponseEntity<List<Tarefa>> hoje() {
		return ResponseEntity.ok(tarefaService.findHoje());
	}
	
	@GetMapping("/seteDias")
	public ResponseEntity<List<Tarefa>> seteDias() {
		return ResponseEntity.ok(tarefaService.findSeteDias());
	}

}
