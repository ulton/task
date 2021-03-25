package com.go.task;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.go.task.model.Projeto;
import com.go.task.repository.ProjetoRepository;
import com.go.task.service.ProjetoService;
import com.go.task.util.ProjetoCreator;

@ExtendWith(SpringExtension.class)
public class ProjetoServiceTeste {

	@InjectMocks
	ProjetoService service;

	@Mock
	ProjetoRepository projRepoMock;

	@BeforeEach
	public void setup() {

		BDDMockito.when(projRepoMock
				.save(ArgumentMatchers.any(Projeto.class)))
				.thenReturn(ProjetoCreator.createValidProjeto());

		BDDMockito.when(projRepoMock
				.findById(ArgumentMatchers.eq(200L))).thenReturn(null);

		BDDMockito.when(projRepoMock
				.findById(ArgumentMatchers.eq(1L)))
				.thenReturn(Optional.of(ProjetoCreator.createValidProjeto()));

		BDDMockito.when(projRepoMock
				.findAll())
				.thenReturn(List.of(ProjetoCreator.createValidProjeto()));

	}

	@Test
	void findAll_returnListojProjeto_WhenSucessful() {
		
		String expectedName = ProjetoCreator.createValidProjeto().getNome();
		
		List<Projeto> projetos = projRepoMock.findAll();
		Assertions.assertThat(projetos)
			.isNotNull()
			.isNotEmpty()
			.hasSize(1);
		
		Assertions.assertThat(projetos.get(0).getNome()).isEqualTo(expectedName);
	}
	
	
	@Test
	void findById_returnProjeto_WhenSucessful() {
		
		Optional<Projeto> projetoExpected = Optional.of(ProjetoCreator.createValidProjeto());
		
		Optional<Projeto> projeto = projRepoMock.findById(1L);
		
		Assertions.assertThat(projeto)
			.isNotNull()
			.isEqualTo(projetoExpected);
	}
	
	@Test
	void findById_returnNull_WhenProjetoIsNotFound() {
		
		Optional<Projeto> projeto = projRepoMock.findById(200L);
		
		Assertions.assertThat(projeto)
			.isNull();
	}

	@Test
	void alterar_returnProjeto_WhenSucessful() {
		
	}
	
	@Test
	void excluir_returnVoid_WhenSucessful() {
		
	}

}
