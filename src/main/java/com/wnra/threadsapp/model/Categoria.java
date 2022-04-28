package com.wnra.threadsapp.model;

import java.util.List;

public class Categoria {
	
	private String nome;
	private List<Thread> threads;
	
	public Categoria() {
	}
	public Categoria(String nome, List<Thread> threads) {
		this.nome = nome;
		this.threads = threads;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Thread> getThreads() {
		return threads;
	}
	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}
	
	

}
