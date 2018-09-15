package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AtividadeDAO;
import Interface.Iatividade;
import Model.Atividade;

@WebServlet("/atividadeS")
public class atividadeServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String acao = request.getParameter("acao");
		
		if(acao==null)acao="i";
		
		if (acao.equalsIgnoreCase("i")) {
			Iatividade eq = new AtividadeDAO();
			Atividade ob = new Atividade();
			ob.setDescricao(request.getParameter("dado"));
			String resposta = eq.insertAtividade((ob));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadAtividade.jsp';");
			out.println("</script>");
		}
		if (acao.equalsIgnoreCase("e")) {
			Iatividade eq = new AtividadeDAO();
			String resposta = eq.deleteAtividade(request.getParameter("dado"));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadAtividade.jsp';");
			out.println("</script>");
		}
	}
}

