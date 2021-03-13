package com.go.task.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.go.task.exception.InternalServerErrorException;
import com.go.task.model.Projeto;
import com.go.task.model.Tarefa;
import com.go.task.model.input.ProjetoInput;
import com.go.task.model.output.ProjetoMenuList;
import com.go.task.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private ModelMapper modelMapper;

	public Projeto save(ProjetoInput view) {
		
		Projeto projeto = modelMapper.map(view, Projeto.class);
		
		if (projeto.getProjetoPai() != null && projeto.getProjetoPai().getId() != null) {

			Optional<Projeto> buscaPai = projetoRepository.findById(projeto.getProjetoPai().getId());

			if (buscaPai.isPresent())
				projeto.setProjetoPai(buscaPai.get());

		}

		if (projeto.getCriacao() == null)
			projeto.setCriacao(LocalDateTime.now());

		return projetoRepository.save(projeto);
	}

	public List<Projeto> findAll() {

		List<Projeto> projetos = projetoRepository.findAll();
		return projetos;
	}

	public Projeto findById(Long id) {

		Optional<Projeto> busca = projetoRepository.findById(id);

		if (busca.isPresent()) {
			return busca.get();
		}

		return null;
	}

	public Projeto alterar(Projeto projeto) {

		Optional<Projeto> busca = projetoRepository.findById(projeto.getId());
		Projeto save = null;

		if (busca.isPresent()) {
			save = projetoRepository.save(busca.get());
		}

		return save;

	}

	@Transactional
	public boolean excluir(Long id) {

		Optional<Projeto> busca = projetoRepository.findById(id);

		if (busca.isPresent()) {
			try {
				Projeto projeto = busca.get();
				List<Tarefa> tarefas = tarefaService.findByProjeto(projeto);
				tarefaService.delete(tarefas);
				projetoRepository.delete(projeto);
				return true;
			} catch (Exception e) {
				throw new InternalServerErrorException("Erro ao excluir Projeto");
			}
		}

		return false;
	}

	public List<ProjetoMenuList> getProjetosMenuList() {
		
		List<Projeto> findAll = findAll();
		
		List<ProjetoMenuList> projsMenu = new ArrayList<>();
		
		findAll.forEach(p -> {
			ProjetoMenuList projMenu = new ProjetoMenuList();
			projMenu.setId(p.getId());
			projMenu.setNome(p.getNome());
			projsMenu.add(projMenu );
		});
		
		return projsMenu;
	}

}
