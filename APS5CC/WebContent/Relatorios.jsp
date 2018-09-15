<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Relatórios</title>
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
				<li><a href="Relatorios.jsp" class="z-depth-3">Relatórios</a></li>
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
						style="font-size: 45px; color: rgb(0, 0, 0)">Relatórios</h5>
				</div>
			</div>
		</div>
		<div class="parallax">
			<img src="img\relatorio.jpg" alt="Unsplashed background img 2">
		</div>
	</div>
<div class="Row">
	<ul 
		style="margin-left: 10%; margin-right: 10%; margin-top: 2%; margin-bottom: 5%">
		<form action="RelatorioS">
			<li style="margin-top: 5%;">
			<div class="input-field col s6" style="margin-left: 10%;margin-right: 10%;">Data Inicial :
					<input name="dataInicial" type="text" placeholder="0000-00-00"
						class="datepicker"/>
				</div></li><li><div class="input-field col s6" style="margin-left: 10%;margin-right: 10%;">Data Final :
					<input name="dataFinal" type="text" placeholder="0000-00-00"
						class="datepicker"/>
				</div></li><li><div style="margin-left: 10%; width: 260px">Tipo de relatório :
					<select name="acao">
						<option value="OxEL">Relatório - Industria x Ocorrência</option>
						<option value="PxCL">Relatório - Cidades x Ocorrência</option>
						<option value="AxCL">Relatório - Atividades mais ocorridas</option>
						<option value="OxE">Gráfico - Industria x Ocorrência</option>
						<option value="PxC">Gráfico - Cidades x Ocorrência</option>
						<option value="AxC">Gráfico - Atividades mais ocorridas</option>

					</select></div></li><li><div style="margin-left: 50%;">
					<button  class="btn waves-effect waves-light" type="submit" name="action">Gerar<i class="material-icons right">chevron_right</i></button>
					</div>
					</li>
</div>
			</li>
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
		$(document).ready(function() {
			$('.datepicker').datepicker();
		});
	</script>
	<script>
		$('.sidenav').sidenav();
	</script>
	<script>
		$(document).ready(function() {
			$('.modal').modal();
		});
	</script>
	<script type="text/javascript">
	$(document).ready(function(){
	    $('select').formSelect();
	  });</script>
</body>
</html>