package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AgenteDAO;
import Dao.AtividadeDAO;
import Dao.EquipeDAO;
import Dao.FichaDAO;
import Dao.IndustriaDAO;
import Dao.LocalizacaoDAO;
import Interface.Iagente;
import Interface.Iatividade;
import Interface.Iequipe;
import Interface.Ificha;
import Interface.Iindustria;
import Interface.Ilocalizacao;
import Model.Ficha;

@WebServlet("/fichaView")
public class fichaView extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String acao = request.getParameter("acao");

		out.print("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<title>Home</title>\r\n"
				+ "<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"\r\n"
				+ "	rel=\"stylesheet\"/>\r\n"
				+ "<link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\"\r\n"
				+ "	media=\"screen,projection\" />\r\n"
				+ "<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\"\r\n"
				+ "	media=\"screen,projection\" />\r\n"
				+ "<link href=\"css/style2.css\" type=\"text/css\" rel=\"stylesheet\"\r\n"
				+ "	media=\"screen,projection\" />\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + "</head>\r\n"
				+ "\r\n" + "<body><h4 style='text-align:center; background-color:rgba(0,128,128,0.4);height:50px'>Ocorrências</h4><form action='fichaS'><div class=\"container\">");

		Ificha fi = new FichaDAO();

		Iequipe eqp = new EquipeDAO();
		Iatividade atd = new AtividadeDAO();
		Iindustria ind = new IndustriaDAO();
		Iagente agt = new AgenteDAO();
		Ilocalizacao cid = new LocalizacaoDAO();
		Ficha ob = fi.selectFicha(Integer.parseInt(request.getParameter("dado")));

		out.println("<input style='font-size:40px' name='dado' type='text' value='" + ob.getIdFicha() + "' />\r\n"
				+ "								<table class=\"striped\">\r\n"
				+ "									<thead>\r\n" + "										<tr>\r\n"
				+ "											<th></th>\r\n"
				+ "											<th></th>\r\n"
				+ "										</tr>\r\n" + "									</thead>\r\n"
				+ "									<tbody>\r\n" + "										<tr>\r\n"
				+ "											<td>Industria:</td>\r\n"
				+ "											<td>"
				+ ind.selectIndustria(ob.getIdIndustria()).getNomeIndustria() + "</td>\r\n"
				+ "										</tr>\r\n" + "										<tr>\r\n"
				+ "											<td>Atividade:</td>\r\n"
				+ "											<td>"
				+ atd.selectAtividade(ob.getIdAtividade()).getDescricao() + "</td>\r\n"
				+ "										</tr>\r\n" + "										<tr>\r\n"
				+ "											<td>Cidade:</td>\r\n"
				+ "											<td>"
				+ cid.selectLocalizacao(ind.selectIndustria(ob.getIdIndustria()).getLocalizacao()).getNomeCidade()
				+ "</td>\r\n" + "										</tr>\r\n"
				+ "										<tr>\r\n"
				+ "											<td>Grupo:</td>\r\n"
				+ "											<td>"
				+ eqp.selectEquipe(agt.selectAgente(ob.getIdAgente()).getIdEquipe()).getNomeEquipe() + "</td>\r\n"
				+ "										</tr>\r\n" + "										<tr>\r\n"
				+ "											<td>Agente:</td>\r\n"
				+ "											<td>" + agt.selectAgente(ob.getIdAgente()).getNome()
				+ "</td>\r\n" + "										</tr>\r\n"
				+ "										<tr>\r\n"
				+ "											<td>Data da ficha:</td>\r\n"
				+ "											<td>" + ob.getDataFicha() + "</td>\r\n"
				+ "										</tr>\r\n" + "										<tr>\r\n"
				+ "											<td>Observação:</td>\r\n"
				+ "											<td>" + ob.getObservacao() + "</td>\r\n"
				+ "										</tr>\r\n" + "										<tr>\r\n"
				+ "											<td>Status:</td>\r\n"
				+ "											<td>Não Confirmado</td>\r\n"
				+ "										</tr>\r\n" + "									</tbody>\r\n"
				+ "								</table>\r\n" + "\r\n" + "							</div>\r\n"
				+ "							<div class=\"modal-footer\">\r\n");

		if (acao.equalsIgnoreCase("v")) {

			out.print("<a style='margin-left:80%' onclick='window.close()' class=\"waves-effect waves-light btn\">OK</a></div></div></form>");
		}
		if (acao.equalsIgnoreCase("c")) {
			out.print("<input id='confirm' style='margin-left:75%' name='acao' type='submit' class=\"waves-effect waves-light btn\" value='Confirma' /></div></div></form>    ");
			out.print("<script>var ws = new WebSocket('ws://10.1.48.134:8000/events/');\r\n" + 
					"    document.querySelector('#confirm').onclick = function(e) {\r\n" + 
					"        ws.send('/" + agt.selectAgente(ob.getIdAgente()).getIpUser() + "');};</script>");
			
		}
		out.print("<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>\r\n" + 
				"	<script type='text/javascript' src='js/materialize.min.js'></script>\r\n" + 
				"	<script src='js/init.js'></script></body>\r\n" + "</html>");
	}
}