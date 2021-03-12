package com.go.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.task.model.Etiqueta;
import com.go.task.service.EtiquetaService;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

	@Autowired
	private EtiquetaService etiquetaService;

	@PostMapping
	public ResponseEntity<Etiqueta> cadastrar(@RequestBody Etiqueta etiqueta) {
		return ResponseEntity.ok(etiquetaService.save(etiqueta));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Etiqueta>> buscarTodos() {
		return ResponseEntity.ok(etiquetaService.findAll());
	}
	
	@PutMapping
	public ResponseEntity<Etiqueta> alterar(@RequestBody Etiqueta etiqueta) {
		System.out.println(etiqueta);
		return ResponseEntity.ok(etiquetaService.alterar(etiqueta));
	}

}
