package br.inatel.exercicio2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/exercicio2", "root", "root");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
