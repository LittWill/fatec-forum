package com.wnra.threadsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wnra.threadsapp.db.DBConnection;
import com.wnra.threadsapp.model.Thread;

public class ThreadDAO {
	
	public static boolean salvar(Thread thread) {
		boolean isThreadSalva = false;

		try {
			Connection conexao = DBConnection.start();

			PreparedStatement sql = conexao.prepareStatement(
					"INSERT INTO thread (id, autor_nome, data_postagem, categoria_nome, questao) VALUES(?, ?, ?, ?, ?)");

			sql.setString(1, thread.getId());
			sql.setString(2, thread.getAutorNome());
			sql.setObject(3, thread.getDataPostagem());
			sql.setString(4, thread.getCategoria().getNome());
			sql.setObject(5, thread.getQuestao());
			sql.executeUpdate();
			isThreadSalva = true;
			conexao.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return isThreadSalva;
	}
	
	public static List <Thread> listarThreads(){
		List<Thread> threads = new ArrayList<>();

		try {

			Connection conexao = DBConnection.start();

			PreparedStatement sql = conexao.prepareStatement(
					"SELECT id, autor_nome, data_postagem, categoria_nome, questao, likes, dislikes FROM thread");
			ResultSet resultado = sql.executeQuery();
			while (resultado.next()) {
				Thread thread = new Thread(
						  resultado.getString("id"),
						  resultado.getString("autor_nome"), 
						  (LocalDateTime) resultado.getObject("data_postagem"), 
						  CategoriaDAO.obter(resultado.getString("categoria_nome")), 
						  resultado.getString("questao"), 
						  resultado.getInt("likes"), 
						  resultado.getInt("dislikes")
						  );
				
				threads.add(thread);
			}

			conexao.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return threads;

	}


}
