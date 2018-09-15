<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.*,Interface.*,Dao.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet"/>
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style2.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body style="padding-left: 10%; padding-right: 10%; background-color: rgba(212, 212, 212, 0.37)">
	
	<div>
	<form action="equipeS">
			<ul class="listaNav" style="margin-left: 10%; margin-right: 10%; margin-top: 2%; margin-bottom: 5%">
				<li style="width: 300px; margin-top: 5%;">
					<div class="input-field col s6">
						<input placeholder="Digite o Nome" name="dado" id="first_name" type="text" class="validate"></input>
						<label for="first_name" style="margin: -2px">Nome</label>
					</div>
				</li>
				<li><div class="input-field col s2">
						<input type="submit" style="color: white" class="waves-effect waves-light btn-large" value="Incluir"/>
					</div></li>
			</ul>
			</form>
	</div>


	<div style="padding: 10%; padding-top: 2%; padding-bottom: 2%">
		<table class="highlight">
			<thead>
				<tr>
					<th>ID</th>
					<th>Grupo</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<%
					Iequipe dao = new EquipeDAO();
					List<Equipe> lista = dao.selectAll();
					for (Equipe ob : lista) {
				%>
				<tr>
				
					<td><%=ob.getIdEquipe()%></td>
					<td><%=ob.getNomeEquipe()%></td>
					<td><a class="waves-effect waves-light btn-large" style="background-color: brown" href="equipeS?acao=E&dado=<%=ob.getIdEquipe()%>">Excluir</a></td>
				
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script src="js/init.js"></script>
</body>

</html>