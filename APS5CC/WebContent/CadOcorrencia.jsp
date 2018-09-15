<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="Model.*,Interface.*,Dao.*,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link href="css/materialize.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<link href="css/style2.css" type="text/css" rel="stylesheet"
	media="screen,projection" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>

<body
	style="padding-left: 10%; padding-right: 10%; background-color: rgba(212, 212, 212, 0.37)">

	<div class="row">
		<form  class="col s12" action="fichaS">
			<ul class="listaNav"
				style="margin-left: 10%; margin-right: 10%; margin-top: 2%; margin-bottom: 5%">
				
				<li>
					<div class="input-field col s12">
						<select name="agente">
							<%
								Iagente ag = new AgenteDAO();
								List<Agente> listag = ag.selectAll();
								for (Agente obag : listag) {
							%>
							<option value="<%=obag.getIdAgente()%>"><%=obag.getNome()%></option>
							<%
								}
							%>
						</select>
					</div>
				</li>
				<li>
					<div class="input-field col s12">
						<select name="atividade">
							<%
								Iatividade at = new AtividadeDAO();
								List<Atividade> listat = at.selectAll();
								for (Atividade obat : listat) {
							%>
							<option value="<%=obat.getIdAtividade()%>"><%=obat.getDescricao()%></option>
							<%
								}
							%>
						</select>
					</div>
				</li>
				<li>
					<div class="input-field col s12">
						<select name="industria">
							<%
								Iindustria i = new IndustriaDAO();
								List<Industria> listin = i.selectAll();
								for (Industria obi : listin) {
							%>
							<option value="<%=obi.getIdIndustria()%>"><%=obi.getNomeIndustria()%></option>
							<%
								}
							%>
						</select>
					</div>
				</li>
				<li>
				</li>
				
				<li style="width: 300px; margin-top: 5%;">
					<div class="input-field col s12">
						<textarea id="textarea2" name="observacao" class="materialize-textarea" data-length="255"></textarea><label for="textarea2">Observação</label>
					</div>
				</li>
				
				<li><div class="input-field col s12">
						<input id="confirm" type="submit" style="color: white"
							class="waves-effect waves-light btn-large" value="Incluir" />
					</div></li>
			</ul>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	<script src="js/init.js"></script>
	<script>
		$(document).ready(function() {
			$('select').formSelect();
		});
	</script>
	<script type="text/javascript">
	$(document).ready(function() {
	    $('input#input_text, textarea#textarea2').characterCounter();
	  });</script>
	  <script>
	
	var ws = new WebSocket("ws://10.1.48.134:8000/events/");

    document.querySelector('#confirm').onclick = function(e) {
        ws.send('/10.1.48.134');
    };
    </script>
</body>

</html>