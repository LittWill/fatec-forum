package com.wnra.threadsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wnra.threadsapp.db.DBConnection;
import com.wnra.threadsapp.model.Categoria;

public class CategoriaDAO {

	public static Categoria obter(String nome) {
		Categoria categoria = null;
		try {

			Connection conexao = DBConnection.start();

			PreparedStatement sql = conexao.prepareStatement(
					"SELECT nome FROM categoria WHERE nome=?");
			sql.setString(1, nome);
			ResultSet resultado = sql.executeQuery();
			while (resultado.next()) {
				categoria = new Categoria(nome, null);
			}
			conexao.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return categoria;

	}
}
