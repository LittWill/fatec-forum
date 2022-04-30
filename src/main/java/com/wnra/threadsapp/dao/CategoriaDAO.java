package com.wnra.threadsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.wnra.threadsapp.db.DBConnection;
import com.wnra.threadsapp.model.Categoria;
import com.wnra.threadsapp.model.Thread;

public class CategoriaDAO {

	public static Categoria obterCategoria(String nome) {
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

	public static List<Categoria> listarCategorias() {
		List<Categoria> categorias = new ArrayList<>();
		try {
			Connection conexao = DBConnection.start();

			PreparedStatement sql = conexao
					.prepareStatement("SELECT nome FROM categoria");
			ResultSet resultado = sql.executeQuery();
			while (resultado.next()) {
				Categoria categoria = new Categoria(resultado.getString("nome"),
						null);
				categorias.add(categoria);
			}

			conexao.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return categorias;

	}
}
