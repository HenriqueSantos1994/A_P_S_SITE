package Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Dao.IndustriaDAO;
import Interface.Iindustria;
import Model.Industria;
import Serializer.IndustriaSerializer;

@Path("/industria")
public class IndustriaService {
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response industria_list() {
		System.out.println("Entrou no service INDUSTRIA");
		Iindustria dao = new IndustriaDAO();
		List<Industria> industrias = dao.selectAll();
		
		IndustriaSerializer serializer = new IndustriaSerializer();
		
		return Response.status(200).entity(String.valueOf(serializer.IndustriaSerializerList(industrias))).build();
		
	  }

	  @Path("{idIndustria}")
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response industria_detail(@PathParam("idIndustria") int idIndustria) {
		  
		  Iindustria dao = new IndustriaDAO();
		  
		  Industria industria = dao.selectIndustria(idIndustria);
		  
		  IndustriaSerializer serializer = new IndustriaSerializer();
		  
		  return Response.status(200).entity(String.valueOf(serializer.IndustriaSerializerObj(industria))).build();
	  }
	  
	  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public Response industria_insert(
			  @FormParam("idIndustria") int IdIndustria,
	          @FormParam("nomeIndustria") String nomeIndustria,
	          @FormParam("idCidade") int idCidade) {
		  
		  
		  Industria industria = new Industria();
		  industria.setIdIndustria(IdIndustria);
		  industria.setNomeIndustria(nomeIndustria);
		  industria.setLocalizacao(idCidade);
		  Iindustria dao = new IndustriaDAO();
		  String resposta = dao.insertIndustria(industria);
		  return Response.status(200).entity(String.valueOf(resposta)).build();
	  }
	  
	  @Path("{idIndustria}")
	  @PUT
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public Response industria_update(
			  @FormParam("idIndustria") int IdIndustria,
	          @FormParam("nomeIndustria") String nomeIndustria,
	          @FormParam("idCidade") int idCidade) {
		  
		  
		  Industria industria = new Industria();
		  industria.setIdIndustria(IdIndustria);
		  industria.setNomeIndustria(nomeIndustria);
		  industria.setLocalizacao(idCidade);
		  Iindustria dao = new IndustriaDAO();
		  String resposta = dao.insertIndustria(industria);
		  return Response.status(200).entity(String.valueOf(resposta)).build();
	  }

}
