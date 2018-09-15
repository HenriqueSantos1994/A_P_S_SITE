package Service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Dao.FichaDAO;
import Interface.Ificha;
import Model.Ficha;
import Serializer.FichaSerializer;

@Path("/fichas/pendentes")
public class FichasPService {
	@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response ocorrencia_list() {
		System.out.println("Entrou no service FICHA PENDENTE");
		Ificha dao = new FichaDAO();
		List<Ficha> fichas = dao.selectNConfirmados();
		
		FichaSerializer serializer = new FichaSerializer();
		
		return Response.status(200).entity(String.valueOf(serializer.FichaSerializerList(fichas))).build();
		
	  }


}
