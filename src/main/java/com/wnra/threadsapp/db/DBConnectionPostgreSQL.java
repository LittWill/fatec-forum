package com.wnra.threadsapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionPostgreSQL {

	private static String DB_URL = "jdbc:postgresql://127.0.0.1:5432/threadsapp";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "123Fatec";

	public static Connection start() throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		Connection conexao = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASSWORD);
		return conexao;
	}

}