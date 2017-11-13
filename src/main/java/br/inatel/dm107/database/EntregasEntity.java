package br.inatel.dm107.database;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntregasEntity {
	
	public EntregasEntity() {
		// TODO Auto-generated constructor stub
	}
	int id; 

    int num_pedido;

    int id_cliente;

    String nome_recebedor;

    String cpf_recebedor;

    Timestamp data_hora_entrega;
    
    public String getCpf_recebedor() {
		return cpf_recebedor;
	}
    public Timestamp getData_hora_entrega() {
		return data_hora_entrega;
	}
    public int getId_cliente() {
		return id_cliente;
	}
    
    public String getNome_recebedor() {
		return nome_recebedor;
	}
    
    public int getNum_pedido() {
		return num_pedido;
	}
    
    public int getId() {
		return id;
	}
    
    public void setCpf_recebedor(String cpf_recebedor) {
		this.cpf_recebedor = cpf_recebedor;
	}
    
    public void setData_hora_entrega(Timestamp data_hora_entrega) {
		this.data_hora_entrega = data_hora_entrega;
	}
    public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
    public void setId(int id) {
		this.id = id;
	}
    public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}
    public void setNome_recebedor(String nome_recebedor) {
		this.nome_recebedor = nome_recebedor;
	}
    

	

}
