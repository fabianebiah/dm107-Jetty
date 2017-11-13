package br.inatel.dm107;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

import br.inatel.dm107.database.UsuariosDAO;
import br.inatel.dm107.database.UsuariosEntity;

public class AuthenticationService {
	
	  public boolean authenticate(String credentials) {
	     
	        System.out.println(credentials);

	        if (null == credentials)
	            return false;
	        // extraindo o valor vindo do header "Basic encodedstring" for Basic
	        //Exemplo: "Basic YWRtaW46YWRtaW4="
	        final String encodedUserPassword = credentials.replaceFirst("Basic"+ " ", "");
	        String usernameAndPassword = null;
	        try {
	            byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
	            usernameAndPassword = new String(decodedBytes, "UTF-8");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        final String usernameAndPassSplit[] = usernameAndPassword.split(":");
	        final String username = usernameAndPassSplit[0];
	        final String password = usernameAndPassSplit[1];

	        // alterar para pegar user do banco
	        UsuariosDAO userdao = new UsuariosDAO();
	        UsuariosEntity user = null;
			try {
				user = userdao.getLogin(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (user!=null) {
	        	return true;
	        }
	        else {
	        	return false;	     
	        }

	    }

}
