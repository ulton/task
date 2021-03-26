package com.go.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.task.model.Projeto;
import com.go.task.model.Tarefa;
import com.go.task.model.input.ProjetoInput;
import com.go.task.model.output.ProjetoMenuList;
import com.go.task.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService projetoService;

	@PostMapping
	public ResponseEntity<Projeto> salvar(@RequestBody ProjetoInput projeto) {
		return ResponseEntity.ok(projetoService.save(projeto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Projeto> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(projetoService.findById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Projeto>> buscarTodos() {
		return ResponseEntity.ok(projetoService.findAll());
	}
	
	@GetMapping("/{id}/tarefas")
	public ResponseEntity<List<Tarefa>> bustarTarefasDoProjeto(@PathVariable Long id) {
		return ResponseEntity.ok(projetoService.findTarefas(id));
	}

	@PutMapping
	public ResponseEntity<Void> alterar(@RequestBody Projeto projeto) {
		projetoService.alterar(projeto);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		projetoService.excluir(id);
		return ResponseEntity.ok().build();
	}
	
	
	
	@GetMapping("/projetosMenuList")
	public ResponseEntity<List<ProjetoMenuList>> getProjetosMenuList() {
		return ResponseEntity.ok(projetoService.getProjetosMenuList());
	}

}
