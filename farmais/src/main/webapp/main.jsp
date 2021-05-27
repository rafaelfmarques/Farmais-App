<%@ page language="java" contentType="text/html; charset = utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Remedio"%>
<%@ page import="java.util.ArrayList"%>

<%
ArrayList<Remedio> lista = (ArrayList<Remedio>) request.getAttribute("remedios");
%>

<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="assets/farmacia.png">

<title>Farmais</title>

<link href="frameworks/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary static-top">
		<div class="container">
			<a class="navbar-brand"> <img src="assets/farmacia.png"
				width="60" height="60"> Farmais
			</a>
 		<div class="collapse navbar-collapse d-lg-flex justify-content-end">
 			<ul class="navbar-nav">
 				<li class="nav-item active"><a class="nav-link"href="adicionar.jsp">Adicionar ao estoque</a></li>
 				<li class="nav-item active"><a class="nav-link"href="login"><img src="assets/logout.png" title="Deslogar" style="width:30px;height:30px;" alt="Voltar"></a></li>
 				
			</ul>
			
 		</div>
			
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<p class="lead">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome técnico</th>
							<th scope="col">Nome Comercial</th>
							<th scope="col">Nome do Fabricante</th>
							<th scope="col">Tipo da tarja</th>
							<th scope="col">Data</th>
							<th scope="col">Opções</th>


						</tr>
					</thead>
					<tbody>

						<%
						for (int i = 0; i < lista.size(); i++) {
						%>
						<tr>
							<td><%=lista.get(i).getIdrem()%></td>
							<td><%=lista.get(i).getNome_tec()%></td>
							<td><%=lista.get(i).getNome_com()%></td>
							<td><%=lista.get(i).getNome_fab()%></td>
							<td><%=lista.get(i).getTipo_tarja()%></td>
							<td><%=lista.get(i).getData_atual()%></td>
							<td><a href="list?idrem=<%=lista.get(i).getIdrem()%>">
									<img src="assets/editar.png" alt="Editar" title="Editar item" style="width: 25px; height: 25px;">
								</a> 
									
								<a href="javascript: confirma(<%=lista.get(i).getIdrem()%>)">
									<img src="assets/remover.png" alt="Remover" title="Remover item" style="width: 40px; height: 40px;">
								</a>
								
							</td>
						</tr>

						<%
						}
						%>
					</tbody>
				</table>

			</div>
		</div>
	</div>

	<script src="frameworks/jquery/jquery.slim.min.js"></script>
	<script src="frameworks/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="script.js"></script>
</body>

</html>