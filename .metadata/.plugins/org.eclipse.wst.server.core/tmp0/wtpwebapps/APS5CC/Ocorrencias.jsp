<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.*,Interface.*,Dao.*,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ocorrências</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style2.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="js/angular.mim.js"></script>
<script src="js/ocorrenciaController.js"></script>
</head>

<body ng-controller="OcorrênciasController">
	<div id="Menu">
		<nav>
		<div class="nav-wrapper" style="background-color: teal;">

			<a href="#" class="brand-logo left">APS5 CC</a> <a href="#"
				data-target="menu-mobile" class="sidenav-trigger right"><i
				class="material-icons">menu</i></a>

			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="Index.jsp">Home</a></li>
				<li><a href="Ocorrencias.jsp" class="z-depth-3">Ocorrências</a></li>
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
					<h5 class="header col s12 light"
						style="font-size: 45px; color: rgb(0, 0, 0)">Ocorrência</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="img\lista.jpg" alt="Unsplashed background img 2">
		</div>
	</div>


	<div>
		<p class="flow-text"
			style="text-align: left; margin-left: 10%; margin-bottom: -10px">Ocorrência
			não lidas</p>
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
					<th></th>
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
					<td><%=cid.selectLocalizacao(ind.selectIndustria(ob.getIdIndustria()).getLocalizacao())
							.getNomeCidade()%></td>
					<td><%=eqp.selectEquipe(agt.selectAgente(ob.getIdAgente()).getIdEquipe()).getNomeEquipe()%></td>
					<td><%=agt.selectAgente(ob.getIdAgente()).getNome()%></td>
					<td><a id='confirm'
						class="waves-effect waves-light btn modal-trigger  red  pulse"
						href="fichaView?acao=c&dado=<%=ob.getIdFicha()%>">Ver</a></td>
				</tr>
				<%
					}
					}
				%>
			</tbody>

		</table>
	</div>

	<div class="input-field col s6">
		<p class="flow-text"
			style="text-align: left; margin-left: 10%; margin-bottom: -10px">Ocorrência
			lidas</p>
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
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					Iequipe eqp2 = new EquipeDAO();
					Iatividade atd2 = new AtividadeDAO();
					Ificha fic2 = new FichaDAO();
					Iindustria ind2 = new IndustriaDAO();
					Iagente agt2 = new AgenteDAO();
					Ilocalizacao cid2 = new LocalizacaoDAO();
					List<Ficha> lista2 = fic2.selectConfirmados();
					if (lista != null) {
						for (Ficha ob2 : lista2) {
				%>
				<tr>
					<td><%=ob2.getIdFicha()%></td>
					<td><%=ind2.selectIndustria(ob2.getIdIndustria()).getNomeIndustria()%></td>
					<td><%=atd2.selectAtividade(ob2.getIdAtividade()).getDescricao()%></td>
					<td><%=cid2.selectLocalizacao(ind2.selectIndustria(ob2.getIdIndustria()).getLocalizacao())
							.getNomeCidade()%></td>
					<td><%=eqp2.selectEquipe(agt2.selectAgente(ob2.getIdAgente()).getIdEquipe()).getNomeEquipe()%></td>
					<td><%=agt2.selectAgente(ob2.getIdAgente()).getNome()%></td>
					<td><a class="waves-effect waves-light btn modal-trigger" href="fichaView?acao=V&dado=<%=ob2.getIdFicha()%>" target="_blank">Ver</a>
						</td>
				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>
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
						<li><a class="grey-text text-lighten-3" href="Relatorios.jsp">Relatórios</a></li>
						<li><a class="grey-text text-lighten-3" href="Cadastrar.jsp">Cadastrar</a></li>
						<li><a class="grey-text text-lighten-3" href="QuemSomos.jsp">Quem
								somos</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="footer-copyright">
			<div class="container">© 2018 APS - Ciências da Computação - 4º e 5º Semestre</div>
		</div>
		</footer>
	</div>



	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script src="js/init.js"></script>
	<script>
		$('.sidenav').sidenav();
	</script>
	<script>
		$(document).ready(function() {
			$('.modal').modal();
		});
	</script>
	
	
    <script>
	
    var ws = new WebSocket("ws://10.1.48.134:8000/events/");
    ws.onmessage = function(e) {
    	//window.location.reload();
        M.toast({html: 'Existem novas ocorrências a serem confirmadas!'});
    };

    </script>


</body>
</html>