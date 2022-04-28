package com.wnra.threadsapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Resposta {
	
	private String id;
	private LocalDateTime dataPostagem;

	public Resposta(Integer id) {
		this.id = UUID.randomUUID().toString();
		this.dataPostagem = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDateTime dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	
	
	
	

}
