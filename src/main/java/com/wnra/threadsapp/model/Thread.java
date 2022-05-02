package com.wnra.threadsapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Thread {

	private String id;
	private String autorNome;
	private LocalDateTime dataPostagem;
	private Categoria categoria;
	private String questao;
	private int likes;
	private int dislikes;
	private List<Resposta> respostas;
	
	public Thread(String id, String autorNome, LocalDateTime dataPostagem,
			Categoria categoria, String questao, int likes, int dislikes, List<Resposta> respostas) {
		this.id = id;
		this.autorNome = autorNome;
		this.dataPostagem = dataPostagem;
		this.categoria = categoria;
		this.questao = questao;
		this.likes = likes;
		this.dislikes = dislikes;
		this.respostas = respostas;
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
	
	public String getDataPostagemFormatada() {
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return this.dataPostagem.format(pattern);
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
	
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	@Override
	public String toString() {
		return "Thread [id=" + id + ", autorNome=" + autorNome
				+ ", dataPostagem=" + dataPostagem + ", categoria=" + categoria.getNome()
				+ ", questao=" + questao + ", likes=" + likes + ", dislikes="
				+ dislikes + "]";
	}
	
	

}
