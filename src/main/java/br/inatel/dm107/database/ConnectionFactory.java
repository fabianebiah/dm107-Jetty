package br.inatel.dm107.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() throws Exception{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	//	return DriverManager.getConnection("jdbc:mysql://localhost/dm107_fabianepaiva?autoReconnect=true&useSSL=false", "root", "root");
		return DriverManager.getConnection("jdbc:mysql://localhost/dm107_fabianepaiva", "root", "root");
	}

}
