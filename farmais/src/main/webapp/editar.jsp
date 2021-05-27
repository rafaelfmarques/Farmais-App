<%@ page language="java" contentType="text/html; charset = utf-8"
	pageEncoding="utf-8" %>
	
<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<meta name="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="assets/farmacia.png">
<link rel="stylesheet" href="css/style.css">

<title>Farmais</title>

<!-- Bootstrap core CSS -->
<link href="frameworks/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary static-top">
		<div class="container">
			<a class="navbar-brand"> 
				<img src="assets/farmacia.png" width="60" height="60">
				Farmais
			</a>
			
			<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"href="main"><img src="assets/voltar.png" title="Voltar" style="width:50px;height:50px;" alt="Voltar"></a></li>
			</ul>
			
		</div>
	</nav>

	<!-- Page Content -->
	<div class="card" id="formLogin">
		<div class="card-body">
			<form action="editar">
				<div class="mb-3">
					<label class="form-label">Nome Técnico</label> 
					<input type="text" name="nome_tec" value="<%out.print(request.getAttribute("nome_tec")); %>" placeholder="Digite o nome técnico do medicamento" class="form-control" required>
				</div>
				<div class="mb-3">
					
					<label class="form-label">Nome Comercial</label> 
					
					<input type="text" name="nome_com" value="<%out.print(request.getAttribute("nome_com")); %>" placeholder="Digite o nome comercial" class="form-control" required>
				</div>
				
				<div class="mb-3">
					<label class="form-label">Nome do Fabricante</label> 
					<input type="text" name="nome_fab" value="<%out.print(request.getAttribute("nome_fab")); %>" placeholder="Digite o nome do Fabricante" class="form-control" required>
				</div>

				<div class="mb-3">
					<label class="form-label">Tipo da Tarja</label>

					<div class="form-check">
						<input type="radio" name="tarja" value="Sem tarja" checked> 
							<label class="form-check-label" for="Sem tarja"> Sem tarja </label>
					</div>
					
					<div class="form-check">
						<input type="radio" name="tarja" value="Amarela"> 
						<label class="form-check-label" for="Amarela"> Tarja Amarela  </label>
					</div>
					
					<div class="form-check">
						<input type="radio" name="tarja" value="Vermelha sem Receita"> 
						<label class="form-check-label" for="Vermelha sem Receita"> Tarja Vermelha (Sem receita) </label>
					</div>
					
					<div class="form-check">
						<input type="radio" name="tarja" value="Vermelha com receita"> 
							<label class="form-check-label" for="Vermelha com receita"> Tarja Vermelha (Com receita) </label>
					</div>
					
					<div class="form-check">
						<input type="radio" name="tarja" value="Preta"> 
							<label class="form-check-label" for="Preta"> Tarja Preta </label>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Confirmar</button>
			</form>
		</div>
	</div>
		

	<!-- Bootstrap core JavaScript -->
	<script src="frameworks/jquery/jquery.slim.min.js"></script>
	<script src="frameworks/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>