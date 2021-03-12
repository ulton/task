package com.go.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.task.model.Etiqueta;
import com.go.task.repository.EtiquetaRepository;

@Service
public class EtiquetaService {

	@Autowired
	private EtiquetaRepository etiquetaRepository;

	public Etiqueta save(Etiqueta etiqueta) {
		
		return etiquetaRepository.save(etiqueta);
	}

	public List<Etiqueta> findAll() {
		
		return etiquetaRepository.findAll();
	}

	public Etiqueta alterar(Etiqueta etiqueta) {
		
		Optional<Etiqueta> buscaEtiqueta = etiquetaRepository.findById(etiqueta.getId());
		Etiqueta etiquetaSalva = null;
		
		if (buscaEtiqueta.isPresent()) {
			Etiqueta etiquetaBanco = buscaEtiqueta.get();
			etiquetaBanco.setNome(etiqueta.getNome());
			etiquetaSalva = etiquetaRepository.save(etiquetaBanco);
		}
		
		return etiquetaSalva;
	}

}
