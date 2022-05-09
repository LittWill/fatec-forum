package com.wnra.threadsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wnra.threadsapp.db.DBConnectionMySQL;
import com.wnra.threadsapp.model.Resposta;
import com.wnra.threadsapp.model.Thread;

public class RespostaDAO {

	public static void salvarResposta(Resposta resposta) {
		try {
			Connection conexao = DBConnectionMySQL.start();

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
	
	public static Resposta obterResposta(String id) {
		Resposta resposta = null;
		try {

			Connection conexao = DBConnectionMySQL.start();

			PreparedStatement sql = conexao.prepareStatement(
					"SELECT id, autor_nome, data_postagem, texto, questao, likes, dislikes FROM resposta WHERE id=?");
			sql.setString(1, id);
			ResultSet resultado = sql.executeQuery();
			
			while (resultado.next()) {
				Date date = resultado.getDate("data_postagem");
				String texto = resultado.getString("texto");
				String autorNome = resultado.getString("autor_nome");
				/*LocalDateTime dataPostagem = Instant.ofEpochMilli(date.getTime())
					      .atZone(ZoneId.systemDefault())
					      .toLocalDateTime();
					      */
				LocalDateTime dataPostagem = resultado.getObject("data_postagem", LocalDateTime.class);
				System.out.println(dataPostagem);
				int likes = resultado.getInt("likes");
				int dislikes = resultado.getInt("dislikes");
				resposta = new Resposta(texto, autorNome, dataPostagem, likes, dislikes);
				
			}

			conexao.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resposta;

	}

	public static List<Resposta> listarRespostas(String threadId) {
		List<Resposta> respostas = new ArrayList<>();
		try {

			Connection conexao = DBConnectionMySQL.start();

			PreparedStatement sql = conexao.prepareStatement(
					"SELECT autor_nome, texto, data_postagem, likes, dislikes FROM resposta WHERE thread_id=?");
			sql.setString(1, threadId);
			ResultSet resultado = sql.executeQuery();
			while (resultado.next()) {
				Date date = resultado.getDate("data_postagem");
				String texto = resultado.getString("texto");
				String autorNome = resultado.getString("autor_nome");
				/*LocalDateTime dataPostagem = Instant.ofEpochMilli(date.getTime())
					      .atZone(ZoneId.systemDefault())
					      .toLocalDateTime();
					      */
				LocalDateTime dataPostagem = resultado.getObject("data_postagem", LocalDateTime.class);
				System.out.println(dataPostagem);
				int likes = resultado.getInt("likes");
				int dislikes = resultado.getInt("dislikes");
				
				Resposta resposta = new Resposta(texto, autorNome, dataPostagem, likes, dislikes);
				
				respostas.add(resposta);
			}

			conexao.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return respostas;

	}
	
	public static void atribuirLike(String id) {
		Resposta resposta = RespostaDAO.obterResposta(id);
		
		if (null == resposta) return;

		try {
			Connection conexao = DBConnectionMySQL.start();

			PreparedStatement sql = conexao.prepareStatement(
					"UPDATE resposta SET likes=? WHERE id=?");
			sql.setInt(1, resposta.getLikes() + 1);
			sql.setString(2, resposta.getId());
			sql.executeUpdate();
			conexao.close();
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	}
	}
	
	public static void atribuirDislike(String id) {
		Resposta resposta = RespostaDAO.obterResposta(id);
		
		if (null == resposta) return;

		try {
			Connection conexao = DBConnectionMySQL.start();

			PreparedStatement sql = conexao.prepareStatement(
					"UPDATE resposta SET dislikes=? WHERE id=?");
			sql.setInt(1, resposta.getDislikes() + 1);
			sql.setString(2, resposta.getId());
			sql.executeUpdate();
			conexao.close();
		}

		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	}

}
	
}
