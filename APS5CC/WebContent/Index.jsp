<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="Model.*,Dao.*,Interface.*,java.util.List,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/icons.css" type="text/css" rel="stylesheet" />
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style2.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body>

	<div id="Menu">
		<nav>
			<div class="nav-wrapper" style="background-color: teal;">

				<a href="#" class="brand-logo left">APS5 CC</a> <a href="#"
					data-target="menu-mobile" class="sidenav-trigger right"><i
					class="material-icons">menu</i></a>

				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="Index.jsp" class="z-depth-3">Home</a></li>
					<li><a href="Ocorrencias.jsp">Ocorrências</a></li>
					<li><a href="Relatorios.jsp">Relatórios</a></li>
					<li><a href="Cadastrar.jsp">Cadastrar</a></li>
					<li><a href="QuemSomos.jsp">Quem somos</a></li>
				</ul>

				<ul id="menu-mobile" class="sidenav">
					<li><a href="Index.jsp" class="z-depth-3">Home</a></li>
					<li><a href="Ocorrencias.jsp">Ocorrências</a></li>
					<li><a href="Relatorios.jsp">Relatórios</a></li>
					<li><a href="Cadastrar.jsp">Cadastrar</a></li>
					<li><a href="QuemSomos.jsp">Quem somos</a></li>
				</ul>
			</div>
		</nav>
	</div>

	<div class="parallax-container valign-wrapper">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="row center">
					<h5 class="header col s12 light" style="font-size: 45px">Controle
						de atividades industriais no Rio Tietê</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="img\tiete01.jpg" alt="Unsplashed background img 2">
		</div>
	</div>
<div>


	<ul class="listaNav"
		style="text-align: center; margin-left: 10%; margin-right: 10%">
		<li>

			<canvas id="myChart1" width="300" height="300"></canvas> <script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
			<script>
                    var ctx = document.getElementById("myChart1");
                    var myChart = new Chart(ctx, {
                        type: 'doughnut',
                        data: {
                        	<%
                        	Ificha graf1 = new FichaDAO();
                        	Relatorio rel1 = graf1.OxE();
                        	String label1 = rel1.getId();
                        	
                        	%>
                        labels: [<%=label1%>],
                        datasets: [{
                        label: '# of Votes',
                        <%String date1 = rel1.getNumeros();%>
                        data: [<%=date1%>],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255,99,132,1)',
                            'rgba(54, 162, 235, 1)',    
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                        }]
                        },
                        options: {
                            title: {
                                display: true,
                                text: 'Poluição por Empresa'
                            },
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero:true
                                    }
                                }]
                            }
                        }
                    });
                </script>
		</li>
		<li>

			<canvas id="myChart2" width="300" height="300"></canvas> <script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
			<script>
                    var ctx = document.getElementById("myChart2");
                    var myChart = new Chart(ctx, {
                        type: 'doughnut',
                        data: {
                        	<%
                        	Ificha graf2 = new FichaDAO();
                        	Relatorio rel2 = graf2.PxC();
                        	String label2 = rel2.getId();
                        	
                        	%>
                        labels: [<%=label2%>],
                        datasets: [{
                        label: '# of Votes',
                        <%String date2 = rel2.getNumeros();%>
                        data: [<%=date2%>],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255,99,132,1)',
                            'rgba(54, 162, 235, 1)',    
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                        }]
                        },
                        options: {
                            title: {
                                display: true,
                                text: 'Poluição por Cidade'
                            },
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero:true
                                    }
                                }]
                            }
                        }
                    });
                </script>
		</li>
		<li>

			<canvas id="myChart3" width="300" height="300"></canvas> <script
				src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
			<script>
                    var ctx = document.getElementById("myChart3");
                    var myChart = new Chart(ctx, {
                        type: 'doughnut',
                        data: {
                        	<%
                        	Ificha graf3 = new FichaDAO();
                        	Relatorio rel3 = graf3.AxC();
                        	String label3 = rel3.getId();
                        	
                        	%>
                        labels: [<%=label3%>],
                        datasets: [{
                        label: '# of Votes',
                        <%String date3 = rel3.getNumeros();%>
                        data: [<%=date3%>],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255,99,132,1)',
                            'rgba(54, 162, 235, 1)',    
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                        }]
                        },
                        options: {
                            title: {
                                display: true,
                                text: 'Atividades mais Praticadas'
                            },
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero:true
                                    }
                                }]
                            }
                        }
                    });
                </script>
		</li>
	</ul>
</div>
	<div style="text-align: right; margin-top: 2%; margin-right: 10%">
		<a href="Relatorios.jsp">Ver mais...</a>
	</div>

	<div style="padding: 10%; padding-top: 2%; padding-bottom: 2%">
		<table class="highlight">
			<thead>
				<tr>
					<th>ID</th>
					<th>Empresa</th>
					<th>Atividade</th>
					<th>Cidade</th>
					<th>Grupo</th>
					<th>Agente</th>
				</tr>
			</thead>

			<tbody>
				<%
					Iequipe eqp = new EquipeDAO();
					Iatividade atd = new AtividadeDAO();
					Ificha fic = new FichaDAO();
					Iindustria ind = new IndustriaDAO();
					Iagente agt = new AgenteDAO();
					Ilocalizacao cid = new LocalizacaoDAO();
					List<Ficha> lista = fic.selectNConfirmados();
					if (lista != null) {
						for (Ficha ob : lista) {
				%>
				<tr>
					<td><%=ob.getIdFicha()%></td>
					<td><%=ind.selectIndustria(ob.getIdIndustria()).getNomeIndustria()%></td>
					<td><%=atd.selectAtividade(ob.getIdAtividade()).getDescricao()%></td>
					<td><%=cid.selectLocalizacao(ind.selectIndustria(ob.getIdIndustria()).getLocalizacao()).getNomeCidade()%></td>
					<td><%=eqp.selectEquipe(agt.selectAgente(ob.getIdAgente()).getIdEquipe()).getNomeEquipe()%></td>
					<td><%=agt.selectAgente(ob.getIdAgente()).getNome()%></td>
				</tr>
				<%
					}
					}
				%>
				
			</tbody>
		</table>
	</div>

	<div style="text-align: right; margin-bottom: 2%; margin-right: 10%">
		<a href="Ocorrencias.jsp">Ver mais...</a>
	</div>



	<div>
		<footer class="page-footer">
			<div class="container">
				<div class="row">
					<div class="col l6 s12">
						
					</div>
					<div class="col l4 offset-l2 s12">
						<h5 class="white-text">Links</h5>
						<ul>
							<li><a class="grey-text text-lighten-3" href="Index.jsp">Home</a></li>
							<li><a class="grey-text text-lighten-3"
								href="Ocorrencias.jsp">Ocorrências</a></li>
							<li><a class="grey-text text-lighten-3"
								href="Relatorios.jsp">Relatórios</a></li>
							<li><a class="grey-text text-lighten-3" href="Cadastrar.jsp">Cadastrar</a></li>
							<li><a class="grey-text text-lighten-3" href="QuemSomos.jsp">Quem
									somos</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="footer-copyright">
				<div class="container">© 2018 APS - Ciências da Computação -
					4º e 5º Semestre</div>
			</div>
		</footer>
	</div>
       
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script src="js/init.js"></script>
	<script>$('.sidenav').sidenav();</script>
	<script>
	
    var ws = new WebSocket("ws://10.1.48.134:8000/events/");
    ws.onmessage = function(e) {
    	//window.location.reload();
        M.toast({html: 'Existem novas ocorrências a serem confirmadas!'});
    };

    </script>
	
    

</body>
</html>