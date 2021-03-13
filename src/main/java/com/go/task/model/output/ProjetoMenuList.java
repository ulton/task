package com.go.task.model.output;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProjetoMenuList {

	@EqualsAndHashCode.Include
	private Long id;

	private String nome;
	
	public ProjetoMenuList() {
	}

}
