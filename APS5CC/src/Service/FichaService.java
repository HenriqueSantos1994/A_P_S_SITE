package Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import Dao.FichaDAO;
import Interface.Ificha;
import Model.Ficha;
import Serializer.FichaSerializer;

@Path("/ficha")
public class FichaService {
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response ocorrencia_list() {
		System.out.println("Entrou no service FICHA");
		Ificha dao = new FichaDAO();
		List<Ficha> fichas = dao.selectAll();
		
		FichaSerializer serializer = new FichaSerializer();
		
		return Response.status(200).entity(String.valueOf(serializer.FichaSerializerList(fichas))).build();
		
	  }

	  @Path("{id}")
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response ocorrencia_detail(@PathParam("id") int id) {
		  
		  Ificha dao = new FichaDAO();
		  
		  Ficha ficha = dao.selectFicha(id);
		  
		  FichaSerializer serializer = new FichaSerializer();
		  
		  return Response.status(200).entity(String.valueOf(serializer.FichaSerializerObj(ficha))).build();
	  }
	  
	  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public Response ocorrencia_insert(
			  @FormParam("atividade") int atividade,
	          @FormParam("industria") int industria,
	          @FormParam("observacao") String observacao,
	          @FormParam("agente") int agente) {
		  
		  Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
		  Ficha ficha = new Ficha();
		  ficha.setIdAtividade(atividade);
		  ficha.setIdIndustria(industria);
		  ficha.setObservacao(observacao);
		  ficha.setIdAgente(agente);
		  ficha.setConfirmacao(0);
		  ficha.setDataFicha(formatador.format(data).toString());
		  Ificha dao = new FichaDAO();
		  String resposta = dao.insertFicha(ficha);
		  System.out.println(resposta);
		  ficha.setIdFicha(1);
		  return Response.status(200).entity(ficha).build();
	  }
	  
	  @Path("{id}")
	  @PUT
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  public Response ocorrencia_update(
			  @PathParam("id") int id,
			  @FormParam("atividade") int atividade,
	          @FormParam("industria") int industria,
	          @FormParam("observacao") String observacao,
	          @FormParam("agente") int agente) {
		  
		  Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
		  Ficha ficha = new Ficha();
		  
		  ficha.setIdFicha(id);
		  ficha.setIdAtividade(atividade);
		  ficha.setIdIndustria(industria);
		  ficha.setObservacao(observacao);
		  ficha.setIdAgente(agente);
		  ficha.setConfirmacao(0);
		  ficha.setDataFicha(formatador.format(data).toString());
		  
		  Ificha dao = new FichaDAO();
		  String resposta = dao.updateFicha(ficha);
		  System.out.println(resposta);
		  ficha.setIdFicha(1);
		  return Response.status(200).entity(ficha).build();
	  }

}
