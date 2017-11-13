package br.inatel.dm107.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuariosDAO {
	
private Connection conn = null;
	
	public UsuariosDAO(){
		if (conn == null) {
			try {
				this.conn = new ConnectionFactory().getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public UsuariosEntity getLogin (String login, String password) throws SQLException {
		String sql = "SELECT * FROM usuarios WHERE login = '" + login
						+ "' and password = '" + password + "'";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		UsuariosEntity usuario = null;
		
		while(rs.next()) {
			
			usuario= new UsuariosEntity();

			usuario.setLogin(rs.getString("login"));
			usuario.setPassword(rs.getString("password"));

		}
		return usuario;
	}

}
