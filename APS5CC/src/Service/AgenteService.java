package Service;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Dao.AgenteDAO;
import Interface.Iagente;
import Model.Agente;
import Serializer.AgenteSerializer;

@Path("/login")
public class AgenteService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response agente_detail(
			@FormParam("email") String email,
	          @FormParam("senha") String senha) {
		System.out.println("Entrou no service AGENTE");
		Iagente dao = new AgenteDAO();

		Agente agente = dao.login(email, senha);
		if(!agente.getEmail().equals(null) || !agente.getEmail().equals("")) {
		AgenteSerializer serializer = new AgenteSerializer();
		
		return Response.status(200).entity(String.valueOf(serializer.AgenteSerializerObj(agente))).build();
		}else {
			return Response.status(400).build();
		}
	}
}