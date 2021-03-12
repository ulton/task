package com.go.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.go.task.controller.ProjetoController;
import com.go.task.service.ProjetoService;

@ExtendWith(SpringExtension.class)
public class ProjetoControllerTest {
	
	@InjectMocks
	private ProjetoController projetoController;
	
	@Mock
	private ProjetoService projetoServiceMock;
	
	@BeforeEach
	void setUp() {
		
	}

}
