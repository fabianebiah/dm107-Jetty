package br.inatel.dm107.database;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuariosEntity {
	
	public UsuariosEntity() {
		// TODO Auto-generated constructor stub
	}

    String login;

    String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

 
	

}
