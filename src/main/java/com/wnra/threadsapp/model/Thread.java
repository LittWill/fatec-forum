package com.wnra.threadsapp.model;

import java.time.LocalDateTime;

public class Thread {

	private Integer id;
	private LocalDateTime dataPostagem;
	private Categoria categoria;
	private String questao;
	private int likes;
	private int dislike;
	public Thread() {
	}
	public Thread(Integer id, LocalDateTime dataPostagem, Categoria categoria,
			String questao, int likes, int dislike) {
		this.id = id;
		this.dataPostagem = dataPostagem;
		this.categoria = categoria;
		this.questao = questao;
		this.likes = likes;
		this.dislike = dislike;
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
		return dislike;
	}
	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

}
