package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Interface.*;
import Model.*;

@WebServlet("/fichaS")
public class fichaServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String acao = request.getParameter("acao");
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
		
		
		if(acao==null)acao="i";
		
		if (acao.equalsIgnoreCase("i")) {
			Ificha fi = new FichaDAO();
			Ficha ob = new Ficha();
			ob.setDataFicha(formatador.format(data).toString());
			ob.setIdAgente(Integer.parseInt(request.getParameter("agente")));
			ob.setIdAtividade(Integer.parseInt(request.getParameter("atividade")));
			ob.setIdIndustria(Integer.parseInt(request.getParameter("industria")));
			ob.setObservacao(request.getParameter("observacao"));
			String resposta = fi.insertFicha(ob);

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadOcorrencia.jsp';");
			out.println("</script>");
		}
		if (acao.equalsIgnoreCase("e")) {
			Ificha fi = new FichaDAO();
			String resposta = fi.deleteFicha(Integer.parseInt(request.getParameter("dado")));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='CadOcorrencia.jsp';");
			out.println("</script>");
		}
		if (acao.equalsIgnoreCase("confirma")) {
			Ificha fi = new FichaDAO();
			String resposta = fi.confirmaFicha(Integer.parseInt(request.getParameter("dado")));

			out.println("<script type=\"text/javascript\">");
			out.println("alert('" + resposta + "');");
			out.println("location='Ocorrencias.jsp';");
			out.println("</script>");
		}
		
	}
}
