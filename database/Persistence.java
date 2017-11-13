package br.inatel.exercicio2.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.inatel.exercicio2.entities.Produto;

public class Persistence {
	
	private static Persistence persistence = null;

	public static Persistence getInstance() {
		if (persistence == null) {
			persistence = new Persistence();
		}
		return persistence;
	}
	

	public Persistence() {
		init();
	}
	public static void init() {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection conn = connectionFactory.getConnection();
		ResultSet rs;
		
	}
	
	
	public Produto getProdutoById(int id) {
		return ProdutoDAO.getInstance().getItemById(1);
	}
		
}
