package br.inatel.dm107.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EntregasDAO {
	
private Connection conn = null;
	
	public EntregasDAO(){
		if (conn == null) {
			try {
				this.conn = new ConnectionFactory().getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public EntregasEntity getEntregaById (int id) throws SQLException {
		String sql = "SELECT * FROM entregas WHERE id = " + String.valueOf(id);
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		EntregasEntity entrega = null;
		
		while(rs.next()) {
			entrega = new EntregasEntity();
			entrega.setId(rs.getInt("id"));
			entrega.setNum_pedido(rs.getInt("num_pedido"));
			entrega.setId_cliente(rs.getInt("id_cliente"));
			entrega.setNome_recebedor(rs.getString("nome_recebedor"));
			entrega.setCpf_recebedor(rs.getString("cpf_recebedor"));
			entrega.setData_hora_entrega(rs.getTimestamp("data_hora_entrega"));	

		}
		return entrega;
	}
	
	public EntregasEntity createEntrega(EntregasEntity entrega)  throws SQLException {
		
		String sql = "INSERT INTO entregas (num_pedido, id_cliente,nome_recebedor,cpf_recebedor,data_hora_entrega) "
				+ "VALUES (?, ?, ?,?,?);";		
	
		PreparedStatement pstm;
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, entrega.getNum_pedido());
		pstm.setInt(2, entrega.getId_cliente());
		pstm.setString(3, entrega.getNome_recebedor());
		pstm.setString(4, entrega.getCpf_recebedor());
		pstm.setTimestamp(5, entrega.getData_hora_entrega());
		pstm.execute();
		return getLastInserted();

	}
	
	private EntregasEntity getLastInserted()  throws SQLException{
		String sql = "SELECT *FROM entregas WHERE id = (SELECT MAX(id) FROM entregas)";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		EntregasEntity entrega = null;
		
		while(rs.next()) {
			entrega = new EntregasEntity();
			entrega.setId(rs.getInt("id"));
			entrega.setNum_pedido(rs.getInt("num_pedido"));
			entrega.setId_cliente(rs.getInt("id_cliente"));
			entrega.setNome_recebedor(rs.getString("nome_recebedor"));
			entrega.setCpf_recebedor(rs.getString("cpf_recebedor"));
			entrega.setData_hora_entrega(rs.getTimestamp("data_hora_entrega"));
		}
		
		return entrega;
	}
}
