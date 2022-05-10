package com.wnra.threadsapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Resposta {
	
	private String id;
	private String autorNome;
	private String texto;
	private LocalDateTime dataPostagem;
	private Thread thread;
	private int likes = 0;
	private int dislikes = 0;
	

	public Resposta(String texto, String autorNome, Thread thread) {
		this.id = UUID.randomUUID().toString();
		this.autorNome = autorNome;
		this.texto = texto;
		this.dataPostagem = LocalDateTime.now();
		this.thread = thread;
	}
	
	public Resposta(String id, String texto, String autorNome, LocalDateTime dataPostagem, int likes, int dislikes) {
		this.id = id;
		this.texto = texto;
		this.autorNome = autorNome;
		this.dataPostagem = dataPostagem;
		this.likes = likes;
		this.dislikes = dislikes;
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
	
	public String getDataPostagemFormatada() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return this.dataPostagem.format(pattern);
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	
	
	
	
}
