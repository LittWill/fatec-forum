package com.wnra.threadsapp.model;

import java.time.LocalDateTime;

public class Resposta {
	
	private Integer id;
	private LocalDateTime dataPostagem;
	
	
	public Resposta() {
	}

	public Resposta(Integer id, LocalDateTime dataPostagem) {
		this.id = id;
		this.dataPostagem = dataPostagem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDateTime dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	
	
	
	

}
