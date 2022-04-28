package com.wnra.threadsapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Resposta {
	
	private String id;
	private String autorNome;
	private LocalDateTime dataPostagem;

	public Resposta(String autorNome) {
		this.id = UUID.randomUUID().toString();
		this.autorNome = autorNome;
		this.dataPostagem = LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutorNome() {
		return autorNome;
	}

	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}

	public LocalDateTime getDataPostagem() {
		return dataPostagem;
	}

	public void setDataPostagem(LocalDateTime dataPostagem) {
		this.dataPostagem = dataPostagem;
	}
	
	
	
	

}
