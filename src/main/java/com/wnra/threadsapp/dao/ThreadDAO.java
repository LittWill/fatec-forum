package com.wnra.threadsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
