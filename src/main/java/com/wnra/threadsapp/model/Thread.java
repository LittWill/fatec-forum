package com.wnra.threadsapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Thread {

	private String id;
	private LocalDateTime dataPostagem;
	private Categoria categoria;
	private String questao;
	private int likes;
	private int dislikes;

	public Thread() {
	}

	public Thread(Categoria categoria,
			String questao, int likes, int dislikes) {
		this.id = UUID.randomUUID().toString();
		this.dataPostagem = LocalDateTime.now();
		this.categoria = categoria;
		this.questao = questao;
		this.likes = likes;
		this.dislikes = dislikes;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getQuestao() {
		return questao;
	}
	public void setQuestao(String questao) {
		this.questao = questao;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislike() {
		return dislikes;
	}
	public void setDislike(int dislike) {
		this.dislikes = dislike;
	}

}
