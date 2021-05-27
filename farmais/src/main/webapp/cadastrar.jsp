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
			<a class="navbar-brand" href="login.jsp"> 
				<img src="assets/farmacia.png" width="60" height="60">
				Farmais
			</a>
			
			<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"href="login.jsp"><img src="assets/voltar.png" title="Voltar" style="width:50px;height:50px;" alt="Voltar"></a></li>
			</ul>

		</div>
	</nav>

	<!-- Page Content -->
	<div class="card" id="formLogin">
		<div class="card-body">
			<form action="cadastrar">
				<div class="mb-3">
					<label class="form-label">Nome</label> 
					<input type="text" name="nome" placeholder="Digite seu nome" class="form-control" required>
				</div>
				
				<div class="mb-3">
					<label class="form-label">Telefone</label> 
					<input type="text" name="fone" placeholder="(00)00000-0000" class="form-control" required>
				</div>
				
				<div class="mb-3">
					<label class="form-label">Email</label> 
					
					<input type="text" name="email" placeholder="Digite o seu e-mail" class="form-control" required>
				</div>
				
				<div class="mb-3">
					<label class="form-label">Senha</label> 
					<input type="password" name="passw" placeholder="Digite sua senha" class="form-control" required>
				</div>

				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
		</div>
	</div>
		

	<!-- Bootstrap core JavaScript -->
	<script src="frameworks/jquery/jquery.slim.min.js"></script>
	<script src="frameworks/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>