package com.go.task;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.go.task.model.Projeto;
import com.go.task.repository.ProjetoRepository;
import com.go.task.util.Inicialization;

@Configuration
public class Configurations {

	@Autowired
	private ProjetoRepository projetoDao;

	@Autowired
	private Inicialization inicialization;

	@PostConstruct
	public void init() {

		projetoDao.save(new Projeto("Caixa de Entrada"));

		inicialization.inicializar();
	}

}
