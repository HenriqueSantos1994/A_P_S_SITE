package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EquipeDAO;
import Model.Equipe;
import Interface.Iequipe;

@WebServlet("/equipeS")
public class equipeServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String acao = request.getParameter("acao");
		
		if(acao==null)acao="i";
		
		if (acao.equalsIgnoreCase("i")) {
			Iequipe eq = new EquipeDAO();
			Equipe ob = new Equipe();
			ob.setNomeEquipe(request.getParameter("dado"));
			String resposta = eq.insertEquipe((ob));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadGrupo.jsp';");
			out.println("</script>");
		}
		if (acao.equalsIgnoreCase("e")) {
			Iequipe eq = new EquipeDAO();
			String resposta = eq.deleteEquipe(request.getParameter("dado"));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadGrupo.jsp';");
			out.println("</script>");
		}
	}
}
