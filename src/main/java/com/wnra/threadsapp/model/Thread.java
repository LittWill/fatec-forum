package com.wnra.threadsapp.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Thread {

	private String id;
	private String autorNome;
	private LocalDateTime dataPostagem;
	private Categoria categoria;
	private String questao;
	private int likes;
	private int dislikes;
	
	public Thread(String id, String autorNome, LocalDateTime dataPostagem,
			Categoria categoria, String questao, int likes, int dislikes) {
		this.id = id;
		this.autorNome = autorNome;
		this.dataPostagem = dataPostagem;
		this.categoria = categoria;
		this.questao = questao;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	public Thread(String autorNome, Categoria categoria,
			String questao) {
		this.id = UUID.randomUUID().toString();
		this.autorNome = autorNome;
		this.dataPostagem = LocalDateTime.now();
		this.categoria = categoria;
		this.questao = questao;
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
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
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
	@Override
	public String toString() {
		return "Thread [id=" + id + ", autorNome=" + autorNome
				+ ", dataPostagem=" + dataPostagem + ", categoria=" + categoria.getNome()
				+ ", questao=" + questao + ", likes=" + likes + ", dislikes="
				+ dislikes + "]";
	}
	
	

}
