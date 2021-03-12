package com.go.task.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.task.model.Comentario;
import com.go.task.model.Etiqueta;
import com.go.task.model.Projeto;
import com.go.task.model.Tarefa;
import com.go.task.repository.EtiquetaRepository;
import com.go.task.repository.ProjetoRepository;
import com.go.task.service.TarefaService;

@Service
public class Inicialization {

	@Autowired
	private TarefaService tarefaService;

	@Autowired
	private EtiquetaRepository etiquetaDao;

	@Autowired
	private ProjetoRepository projetoDao;

	public String inicializar() {

		List<Etiqueta> etiquetas = cadastrarEtiquetas();

		Projeto projeto = cadastrarProjeto();

		Tarefa tarefa1 = cadastrarTarefaComEtiqueta(etiquetas);

		Tarefa tarefa2 = cadastrarTarefaComEtiquetaEProjeto(etiquetas, projeto);

		atualizarTarefaComComentario(tarefa2);

		concluirTarefa(tarefa1);

		return "OK";
	}

	private void concluirTarefa(Tarefa tarefa) {
		tarefa.concluir();
		tarefaService.save(tarefa);

	}

	private void atualizarTarefaComComentario(Tarefa tarefa) {
		List<Comentario> comentarios = new ArrayList<>();
		comentarios.add(new Comentario("Um novo comentario de exemplo"));
		tarefa.setComentarios(comentarios);
		tarefa = tarefaService.save(tarefa);
	}

	private Tarefa cadastrarTarefaComEtiquetaEProjeto(List<Etiqueta> etiquetas, Projeto projeto) {
		Tarefa tarefa = new Tarefa("Exemplo de tarefa 1 ", "Descrição da tarefa", etiquetas, projeto);
		return tarefaService.save(tarefa);
	}

	private Tarefa cadastrarTarefaComEtiqueta(List<Etiqueta> etiquetas) {
		Tarefa tarefa = new Tarefa("Comprar coisas no supermercado", "Descrição da tarefa", etiquetas);
		return tarefaService.save(tarefa);
	}

	private Projeto cadastrarProjeto() {
		return projetoDao.save(new Projeto("Projeto exemplo 1"));
	}

	private List<Etiqueta> cadastrarEtiquetas() {

		Etiqueta etiqueta1 = etiquetaDao.save(new Etiqueta("casa"));
		Etiqueta etiqueta2 = etiquetaDao.save(new Etiqueta("trabalho"));
		Etiqueta etiqueta3 = etiquetaDao.save(new Etiqueta("computador"));

		ArrayList<Etiqueta> etiquetas = new ArrayList<>();
		etiquetas.add(etiqueta1);
		etiquetas.add(etiqueta2);
		etiquetas.add(etiqueta3);

		return etiquetas;
	}

}
