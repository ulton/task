package com.go.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.task.model.Tarefa;
import com.go.task.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@PostMapping
	public ResponseEntity<Tarefa> cadastrar(@RequestBody Tarefa tarefa) {
		Tarefa tarefaSalva = tarefaService.save(tarefa);
		return ResponseEntity.ok(tarefaSalva);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarTodas(@PathVariable Long id) {
		Tarefa tarefa = tarefaService.buscarPorId(id);
		return ResponseEntity.ok(tarefa);
	}
}
