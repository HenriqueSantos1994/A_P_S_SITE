package Service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Dao.AtividadeDAO;
import Interface.Iatividade;
import Model.Atividade;
import Serializer.AtividadeSerializer;

@Path("/atividade")
public class AtividadeService {
	@GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response atividade_list() {
		System.out.println("Entrou no service ATIVIDADE");
		Iatividade dao = new AtividadeDAO();
		List<Atividade> atividades = dao.selectAll();
		
		AtividadeSerializer serializer = new AtividadeSerializer();
		
		return Response.status(200).entity(String.valueOf(serializer.AtividadeSerializerList(atividades))).build();
		
	  }
}
