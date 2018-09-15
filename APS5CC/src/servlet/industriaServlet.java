package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IndustriaDAO;
import Interface.Iindustria;
import Model.Industria;

@WebServlet("/industriaS")
public class industriaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String acao = request.getParameter("acao");

		if (acao == null)
			acao = "i";

		if (acao.equalsIgnoreCase("i")) {
			Iindustria eq = new IndustriaDAO();
			Industria ob = new Industria();
			ob.setNomeIndustria(request.getParameter("dado"));
			ob.setLocalizacao(Integer.parseInt(request.getParameter("cidade")));
			String resposta = eq.insertIndustria((ob));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadEmpresa.jsp';");
			out.println("</script>");
		}
		if (acao.equalsIgnoreCase("e")) {
			Iindustria in = new IndustriaDAO();
			String resposta = in.deleteIndustria(request.getParameter("dado"));
			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadEmpresa.jsp';");
			out.println("</script>");
		}
	}
}