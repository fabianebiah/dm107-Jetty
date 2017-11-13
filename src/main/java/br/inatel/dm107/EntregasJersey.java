package br.inatel.dm107;

import br.inatel.dm107.database.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.inatel.dm107.database.EntregasDAO;
import br.inatel.dm107.database.EntregasEntity;

import javax.ws.rs.core.UriInfo;

//import com.google.gson.Gson;

@Path("/entregas")
public class EntregasJersey {
	
	@Context
	private UriInfo uriInfo; 	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{id}")
	public Response getEntrega(@PathParam("id") int id) {
		
		try {
			EntregasDAO contatoDAO = new EntregasDAO();
			EntregasEntity entrega= contatoDAO.getEntregaById(id);
			String json = GsonUtil.toJson(entrega);
			
			GenericEntity entity = new GenericEntity<String>(json) {};
			return Response.status(Status.OK).entity(entrega).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}			
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON})	
	public Response createItem(EntregasEntity entrega) {
		if ((entrega.getNum_pedido()==0) || (entrega.getId_cliente()==0))
		{
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
		else {
		
			EntregasDAO entregaDAO = new EntregasDAO();
			EntregasEntity newEntrega=null;
			try {
				newEntrega = entregaDAO.createEntrega(entrega);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			GenericEntity entity = new GenericEntity<EntregasEntity>(newEntrega) {}; 
			
			try {
				return Response
						.created(new URI(String.format("%s/$s", uriInfo.getAbsolutePath(),
								newEntrega.getId())))
						.entity(entity)
	
						.build();
			} catch (URISyntaxException e) {
				return Response
						.status(Status.INTERNAL_SERVER_ERROR)
						.build();
			}
		}
		
	}	
		
}

