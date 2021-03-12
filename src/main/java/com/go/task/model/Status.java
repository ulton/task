package com.go.task.model;

public enum Status {

	PENDENTE("p"), FAZENDO("f"), CONCLUIDO("c");
	
	private String status;
	
	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
}
