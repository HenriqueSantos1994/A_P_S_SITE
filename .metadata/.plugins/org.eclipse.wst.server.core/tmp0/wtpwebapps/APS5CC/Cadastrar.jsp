<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar</title>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
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
				<li><a href="Index.jsp">Home</a></li>
				<li><a href="Ocorrencias.jsp">Ocorrências</a></li>
				<li><a href="Relatorios.jsp">Relatórios</a></li>
				<li><a href="Cadastrar.jsp" class="z-depth-3">Cadastrar</a></li>
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
						style="font-size: 45px; color: rgb(0, 0, 0)">Cadastrar</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="img\cadastrar.jpg" alt="Unsplashed background img 2">
		</div>
	</div>



	<div style="padding-left: 10%; padding-right: 10%;">
		<h3>Selecione uma das opções</h3>
	</div>
	<div>
		<ul class="listaNav"
			style="text-align: center; margin-left: 10%; margin-right: 10%; margin-top: 2%; margin-bottom: 5%">
			<li><a class="waves-effect waves-light btn modal-trigger"
				href="#graf1">Grupo</a>
				<div id="graf1" class="modal">
					<div class="modal-content">
						<h4>Cadastro de Grupos</h4>
						<iframe style="height: 400px; width: 100%" src="CadGrupo.jsp"></iframe>
					</div>
					<div class="modal-footer">
						<a href="Cadastrar.jsp"
							class="modal-action modal-close waves-effect waves-green btn-flat">OK</a>
					</div>
				</div></li>
				<li><a class="waves-effect waves-light btn modal-trigger"
				href="#graf2">Agente</a>
				<div id="graf2" class="modal">
					<div class="modal-content">
						<h4>Cadastro de Agentes</h4>
						<iframe style="height: 400px; width: 100%" src="CadAgente.jsp"></iframe>
					</div>
					<div class="modal-footer">
						<a href="Cadastrar.jsp"
							class="modal-action modal-close waves-effect waves-green btn-flat">OK</a>
					</div>
				</div></li>
				<li><a class="waves-effect waves-light btn modal-trigger"
				href="#graf3">Empresa</a>
				<div id="graf3" class="modal">
					<div class="modal-content">
						<h4>Cadastro de Empresa</h4>
						<iframe style="height: 400px; width: 100%" src="CadEmpresa.jsp"></iframe>
					</div>
					<div class="modal-footer">
						<a href="Cadastrar.jsp"
							class="modal-action modal-close waves-effect waves-green btn-flat">OK</a>
					</div>
				</div></li>
				<li><a class="waves-effect waves-light btn modal-trigger"
				href="#graf4">Atividade</a>
				<div id="graf4" class="modal">
					<div class="modal-content">
						<h4>Cadastro de Atividades</h4>
						<iframe style="height: 400px; width: 100%" src="CadAtividade.jsp"></iframe>
					</div>
					<div class="modal-footer">
						<a href="Cadastrar.jsp"
							class="modal-action modal-close waves-effect waves-green btn-flat">OK</a>
					</div>
				</div></li>
		</ul>
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
			$('.datepicker').datepicker();
		});
	</script>
	<script>
		$(document).ready(function() {
			$('.modal').modal();
		});
	</script>

</body>
</html>