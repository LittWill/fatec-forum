package com.wnra.threadsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wnra.threadsapp.db.DBConnection;
import com.wnra.threadsapp.model.Resposta;
import com.wnra.threadsapp.model.Thread;

public class RespostaDAO {

	public static void salvarResposta(Resposta resposta) {
		try {
			Connection conexao = DBConnection.start();

			PreparedStatement sql = conexao.prepareStatement(
					"INSERT INTO resposta (id, autor_nome, texto, data_postagem, thread_id) VALUES(?, ?, ?, ?, ?)");

			sql.setString(1, resposta.getId());
			sql.setString(2, resposta.getAutorNome());
			sql.setString(3, resposta.getTexto());
			sql.setObject(4, resposta.getDataPostagem());
			sql.setObject(5, resposta.getThread().getId());
			sql.executeUpdate();
			conexao.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Resposta> obterRespostasThread(String threadId) {
		List<Resposta> respostas = new ArrayList<>();
		try {

			Connection conexao = DBConnection.start();

			PreparedStatement sql = conexao.prepareStatement(
					"SELECT autor_nome, texto, data_postagem, likes, dislikes FROM resposta WHERE thread_id=?");
			sql.setString(1, threadId);
			ResultSet resultado = sql.executeQuery();
			while (resultado.next()) {
				Resposta resposta = new Resposta(resultado.getString("texto"),
						resultado.getString("autor_nome"),
						LocalDateTime.parse(
								resultado.getString("data_postagem"),
								DateTimeFormatter
										.ofPattern("yyyy-MM-dd HH:mm:ss")),
						resultado.getInt("likes"),
						resultado.getInt("dislikes"));
				respostas.add(resposta);
			}

			conexao.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return respostas;

	}

}
