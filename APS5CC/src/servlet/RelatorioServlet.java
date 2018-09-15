package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Interface.*;
import Model.*;


@WebServlet("/RelatorioS")
public class RelatorioServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		
		Ificha dao = new FichaDAO();
		Iindustria ind = new IndustriaDAO();
		Ilocalizacao loc = new LocalizacaoDAO();
		Iatividade atv = new AtividadeDAO();
		System.out.println("Entrou");
		String acao = request.getParameter("acao");		
		System.out.println(acao);
		String dataFinal = request.getParameter("dataFinal");
		String dataInicial =  request.getParameter("dataInicial");
		
		//String dataInicial = Inicial.substring(6, 10) + "-" + Inicial.substring(3,5) + "-" + Inicial.substring(0,2);
		//String dataFinal = Final.substring(6, 10) + "-" + Final.substring(3,5) + "-" + Final.substring(0,2);
		
		System.out.println(dataInicial);
		System.out.println(dataFinal);
		
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Home</title>\r\n" + 
				"<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"\r\n" + 
				"	rel=\"stylesheet\"/>\r\n" + 
				"<link href=\"css/materialize.css\" type=\"text/css\" rel=\"stylesheet\"\r\n" + 
				"	media=\"screen,projection\" />\r\n" + 
				"<link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\"\r\n" + 
				"	media=\"screen,projection\" />\r\n" + 
				"<link href=\"css/style2.css\" type=\"text/css\" rel=\"stylesheet\"\r\n" + 
				"	media=\"screen,projection\" />\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body><div class=\"container\">");
		out.println("<h2>Relatório</h2>"
				+ "Entre as datas de " + dataInicial + " até " + dataFinal + "\n");
		if (acao.equalsIgnoreCase("OxEL")) {
			List<Relatorio> rel = dao.OxEL(dataInicial, dataFinal);
			out.print("<table class=\"striped\">\r\n" + 
					"        <thead>\r\n" + 
					"          <tr>\r\n" + 
					"              <th>Enpresa</th>\r\n" + 
					"              <th>Numero de Ocorrências</th>\r\n" + 
					"          </tr>\r\n" + 
					"        </thead>\r\n" + 
					"\r\n" + 
					"        <tbody>");
			for(Relatorio r : rel) {
				out.print("<tr>\r\n" + 
						"            <td>" + ind.selectIndustria(Integer.parseInt(r.getId())).getNomeIndustria()  + "</td>\r\n" + 
						"            <td>" + r.getNumeros() + "</td>\r\n" + 
						"          </tr>");
			}
		}
		if (acao.equals("PxCL")) {
			List<Relatorio> rel = dao.PxCL(dataInicial, dataFinal);
			out.print("<table class=\"striped\">\r\n" + 
					"        <thead>\r\n" + 
					"          <tr>\r\n" + 
					"              <th>Cidade</th>\r\n" + 
					"              <th>Numero de Ocorrências</th>\r\n" + 
					"          </tr>\r\n" + 
					"        </thead>\r\n" + 
					"\r\n" + 
					"        <tbody>");
			for(Relatorio r : rel) {
				out.print("<tr>\r\n" + 
						"            <td>" + loc.selectLocalizacao(Integer.parseInt(r.getId())).getNomeCidade()  + "</td>\r\n" + 
						"            <td>" + r.getNumeros() + "</td>\r\n" + 
						"          </tr>");
			}
		}
		if (acao.equals("AxCL")) {
			System.out.println("AxCL eSTÁ AQUI");
			List<Relatorio> rel = dao.AxCL(dataInicial, dataFinal);
			out.print("<table class=\"striped\">\r\n" + 
					"        <thead>\r\n" + 
					"          <tr>\r\n" + 
					"              <th>Atividade</th>\r\n" + 
					"              <th>Numero de Ocorrências</th>\r\n" + 
					"          </tr>\r\n" + 
					"        </thead>\r\n" + 
					"\r\n" + 
					"        <tbody>");
			for(Relatorio r : rel) {
				System.out.println(atv.selectAtividade(Integer.parseInt(r.getId())).getDescricao());
				System.out.println(r.getNumeros());
				out.print("<tr>\r\n" + 
						"            <td>" + atv.selectAtividade(Integer.parseInt(r.getId())).getDescricao() + "</td><td>" + r.getNumeros() + "</td>\r\n" + 
						"            \r\n" + 
						"          </tr>");
			}
		}
		if (acao.equals("OxE")) {
			System.out.println("Entrou no OxE");
			Relatorio rel = dao.OxE(dataInicial, dataFinal);
			System.out.println(rel.getId());
			System.out.println(rel.getNumeros());
			out.print("<div style=\"height: 400px; width: 400px; text-align: center\">\r\n" + 
					"                <canvas id=\"myChart1\" width=\"300\" height=\"300\"></canvas>\r\n" + 
					"        \r\n" + 
					"                <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js\"></script>\r\n" + 
					"                <script>\r\n" + 
					"                    var ctx = document.getElementById(\"myChart1\");\r\n" + 
					"                    var myChart = new Chart(ctx, {\r\n" + 
					"                        type: 'doughnut',\r\n" + 
					"                        data: {\r\n" + 
					"                        labels: ["+ rel.getId() +"],\r\n" + 
					"                        datasets: [{\r\n" + 
					"                        label: '# of Votes',\r\n" + 
					"                        data: ["+ rel.getNumeros() +" ],\r\n" + 
					"                        backgroundColor: [\r\n" + 
					"                            'rgba(255, 99, 132, 0.2)',\r\n" + 
					"                            'rgba(54, 162, 235, 0.2)',\r\n" + 
					"                            'rgba(255, 206, 86, 0.2)',\r\n" + 
					"                            'rgba(75, 192, 192, 0.2)',\r\n" + 
					"                            'rgba(153, 102, 255, 0.2)',\r\n" + 
					"                            'rgba(255, 159, 64, 0.2)'\r\n" + 
					"                        ],\r\n" + 
					"                        borderColor: [\r\n" + 
					"                            'rgba(255,99,132,1)',\r\n" + 
					"                            'rgba(54, 162, 235, 1)',    \r\n" + 
					"                            'rgba(255, 206, 86, 1)',\r\n" + 
					"                            'rgba(75, 192, 192, 1)',\r\n" + 
					"                            'rgba(153, 102, 255, 1)',\r\n" + 
					"                            'rgba(255, 159, 64, 1)'\r\n" + 
					"                        ],\r\n" + 
					"                        borderWidth: 1\r\n" + 
					"                        }]\r\n" + 
					"                        },\r\n" + 
					"                        options: {\r\n" + 
					"                            title: {\r\n" + 
					"                                display: true,\r\n" + 
					"                                text: 'Poluição por Empresa'\r\n" + 
					"                            },\r\n" + 
					"                            scales: {\r\n" + 
					"                                yAxes: [{\r\n" + 
					"                                    ticks: {\r\n" + 
					"                                        beginAtZero:true\r\n" + 
					"                                    }\r\n" + 
					"                                }]\r\n" + 
					"                            }\r\n" + 
					"                        }\r\n" + 
					"                    });\r\n" + 
					"                </script>\r\n" + 
					"\r\n" + 
					"</div>\r\n" + 
					"            <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
					"      ");
		}
		if (acao.equals("PxC")) {
			Relatorio rel = dao.PxC(dataInicial, dataFinal);
			System.out.println(rel.getId());
			System.out.println(rel.getNumeros());
			out.print("<div style=\"height: 400px; width: 400px; text-align: center\">\r\n" + 
					"                <canvas id=\"myChart1\" width=\"300\" height=\"300\"></canvas>\r\n" + 
					"        \r\n" + 
					"                <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js\"></script>\r\n" + 
					"                <script>\r\n" + 
					"                    var ctx = document.getElementById(\"myChart1\");\r\n" + 
					"                    var myChart = new Chart(ctx, {\r\n" + 
					"                        type: 'doughnut',\r\n" + 
					"                        data: {\r\n" + 
					"                        labels: ["+ rel.getId() +"],\r\n" + 
					"                        datasets: [{\r\n" + 
					"                        label: '# of Votes',\r\n" + 
					"                        data: ["+ rel.getNumeros() +" ],\r\n" + 
					"                        backgroundColor: [\r\n" + 
					"                            'rgba(255, 99, 132, 0.2)',\r\n" + 
					"                            'rgba(54, 162, 235, 0.2)',\r\n" + 
					"                            'rgba(255, 206, 86, 0.2)',\r\n" + 
					"                            'rgba(75, 192, 192, 0.2)',\r\n" + 
					"                            'rgba(153, 102, 255, 0.2)',\r\n" + 
					"                            'rgba(255, 159, 64, 0.2)'\r\n" + 
					"                        ],\r\n" + 
					"                        borderColor: [\r\n" + 
					"                            'rgba(255,99,132,1)',\r\n" + 
					"                            'rgba(54, 162, 235, 1)',    \r\n" + 
					"                            'rgba(255, 206, 86, 1)',\r\n" + 
					"                            'rgba(75, 192, 192, 1)',\r\n" + 
					"                            'rgba(153, 102, 255, 1)',\r\n" + 
					"                            'rgba(255, 159, 64, 1)'\r\n" + 
					"                        ],\r\n" + 
					"                        borderWidth: 1\r\n" + 
					"                        }]\r\n" + 
					"                        },\r\n" + 
					"                        options: {\r\n" + 
					"                            title: {\r\n" + 
					"                                display: true,\r\n" + 
					"                                text: 'Poluição por cidade'\r\n" + 
					"                            },\r\n" + 
					"                            scales: {\r\n" + 
					"                                yAxes: [{\r\n" + 
					"                                    ticks: {\r\n" + 
					"                                        beginAtZero:true\r\n" + 
					"                                    }\r\n" + 
					"                                }]\r\n" + 
					"                            }\r\n" + 
					"                        }\r\n" + 
					"                    });\r\n" + 
					"                </script>\r\n" + 
					"\r\n" + 
					"</div>\r\n" + 
					"            <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
					"      ");
		}
		if (acao.equalsIgnoreCase("AxC")) {
			Relatorio rel = dao.AxC(dataInicial, dataFinal);
			System.out.println(rel.getId());
			System.out.println(rel.getNumeros());
			out.print("<div style=\"height: 400px; width: 400px; text-align: center\">\r\n" + 
					"                <canvas id=\"myChart2\" width=\"600\" height=\"600\"></canvas>\r\n" + 
					"        \r\n" + 
					"                <script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js\"></script>\r\n" + 
					"                <script>\r\n" + 
					"                    var ctx = document.getElementById(\"myChart2\");\r\n" + 
					"                    var myChart = new Chart(ctx, {\r\n" + 
					"                        type: 'doughnut',\r\n" + 
					"                        data: {\r\n" + 
					"                        labels: ["+ rel.getId() +"],\r\n" + 
					"                        datasets: [{\r\n" + 
					"                        label: '# of Votes',\r\n" + 
					"                        data: ["+ rel.getNumeros() +" ],\r\n" + 
					"                        backgroundColor: [\r\n" + 
					"                            'rgba(255, 99, 132, 0.2)',\r\n" + 
					"                            'rgba(54, 162, 235, 0.2)',\r\n" + 
					"                            'rgba(255, 206, 86, 0.2)',\r\n" + 
					"                            'rgba(75, 192, 192, 0.2)',\r\n" + 
					"                            'rgba(153, 102, 255, 0.2)',\r\n" + 
					"                            'rgba(255, 159, 64, 0.2)'\r\n" + 
					"                        ],\r\n" + 
					"                        borderColor: [\r\n" + 
					"                            'rgba(255,99,132,1)',\r\n" + 
					"                            'rgba(54, 162, 235, 1)',    \r\n" + 
					"                            'rgba(255, 206, 86, 1)',\r\n" + 
					"                            'rgba(75, 192, 192, 1)',\r\n" + 
					"                            'rgba(153, 102, 255, 1)',\r\n" + 
					"                            'rgba(255, 159, 64, 1)'\r\n" + 
					"                        ],\r\n" + 
					"                        borderWidth: 1\r\n" + 
					"                        }]\r\n" + 
					"                        },\r\n" + 
					"                        options: {\r\n" + 
					"                            title: {\r\n" + 
					"                                display: true,\r\n" + 
					"                                text: 'Atividades mais praticadas'\r\n" + 
					"                            },\r\n" + 
					"                            scales: {\r\n" + 
					"                                yAxes: [{\r\n" + 
					"                                    ticks: {\r\n" + 
					"                                        beginAtZero:true\r\n" + 
					"                                    }\r\n" + 
					"                                }]\r\n" + 
					"                            }\r\n" + 
					"                        }\r\n" + 
					"                    });\r\n" + 
					"                </script>\r\n" + 
					"\r\n" + 
					"</div>\r\n" + 
					"            <script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
					"      ");
		}
		out.print("<a style='margin-left:80%' href='Relatorios.jsp' class='waves-effect waves-light btn'>Voltar</a></div><script src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n" + 
				"    <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\r\n" + 
				"    <script src=\"js/init.js\"></script>"
				+ "</body>\r\n" + 
				"</html>");
		
		
	}
}
