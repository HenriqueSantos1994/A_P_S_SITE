package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AgenteDAO;
import Interface.Iagente;
import Model.Agente;

@WebServlet("/agenteS")
public class agenteServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String acao = request.getParameter("acao");
		
		if (acao == null)
			acao = "i";

		if (acao.equalsIgnoreCase("i")) {
			Iagente ag = new AgenteDAO();
			//Iequipe eq = new EquipeDAO();
			Agente ob = new Agente();
			ob.setNome(request.getParameter("nome"));
			ob.setIdEquipe(Integer.parseInt(request.getParameter("equipe")));
			ob.setEmail(request.getParameter("email"));
			ob.setIpUser(request.getParameter("ip"));
			ob.setSenha(request.getParameter("senha"));
			ob.setTelefone(request.getParameter("telefone"));
			
			String resposta = ag.insertAgente(ob);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadAgente.jsp';");
			out.println("</script>");
		}
		if (acao.equalsIgnoreCase("e")) {
			Iagente ag = new AgenteDAO();
			String resposta = ag.deleteAgente(request.getParameter("dado"));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadAgente.jsp';");
			out.println("</script>");
		}
	}
}
