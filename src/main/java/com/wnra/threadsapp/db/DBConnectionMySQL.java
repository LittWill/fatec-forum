package com.wnra.threadsapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMySQL {

	private static String DB_URL = "jdbc:mysql://localhost/threadsapp";
	private static String DB_USER = "root";
	private static String DB_PASSWORD = "";

	public static Connection start() throws SQLException, ClassNotFoundException {
		Class.forName("org.mysql.cj.jdbc.Driver");
		Connection conexao = DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASSWORD);
		return conexao;
	}

}