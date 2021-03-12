package com.go.task.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.task.model.Projeto;
import com.go.task.model.Tarefa;
import com.go.task.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaDao;

	@Autowired
	private ProjetoService projetoService;

	public Tarefa save(Tarefa tarefa) {
		
		if (tarefa.getCriacao() == null) {
			tarefa.setCriacao(LocalDateTime.now());
		}
		if (tarefa.getProjeto() == null)
			tarefa.setProjeto(projetoService.findById(1L));

		return tarefaDao.save(tarefa);
	}

	public Tarefa buscarPorId(Long id) {
		
		return tarefaDao.findById(id).get();
	}

	public List<Tarefa> findHoje() {

		LocalDateTime now = LocalDateTime.now();

		LocalDateTime dataDe = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0, 1);
		LocalDateTime dataAte = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 23, 59, 59);

		return this.findByLembreteBetween(dataDe, dataAte);
	}

	public List<Tarefa> findSeteDias() {

		LocalDateTime now = LocalDateTime.now();

		LocalDateTime dataDe = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0, 1);
		LocalDateTime dataAte = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 23, 59, 59)
				.plusDays(7);

		return this.findByLembreteBetween(dataDe, dataAte);
	}

	private List<Tarefa> findByLembreteBetween(LocalDateTime dataDe, LocalDateTime dataAte) {
		
		return tarefaDao.findByLembreteBetween(dataDe, dataAte);
	}

	public List<Tarefa> findByProjeto(Projeto projeto) {
		
		return tarefaDao.findByProjeto(projeto);
	}

	public void delete(List<Tarefa> tarefas) {
		
		tarefas.forEach(t -> {
			delete(t);
			});
	}
	
	public void delete(Tarefa tarefa) {
		
		tarefaDao.delete(tarefa);
	}

}
