<%@page import="controller.Controller"%>
<%@ page language="java" contentType="text/html; charset = utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="assets/farmacia.png">
<link rel="stylesheet" href="css/style.css">

<title>Farmais</title>

<!-- Bootstrap core CSS -->
<link href="frameworks/bootstrap/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary static-top">
		<div class="container">
			<a class="navbar-brand"> <img src="assets/farmacia.png"
				width="60" height="60"> Farmais
			</a>
		</div>
	</nav>
	

	<div class="card" id="formLogin">
		<div class="card-body">
			<form action="autenticar">
				<div class="mb-3">
					<label class="form-label">Email</label> <input type="email"
						name="login" placeholder="Digite seu email" class="form-control"
						aria-describedby="emailHelp" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Senha</label> 
						<input type="password" name="senha" placeholder="Digite sua senha" class="form-control" required> 	
				</div>
				<button type="submit" class="btn btn-primary">Entrar</button>

			</form>
			<br />
			<div class="container">
				Ainda não possui conta? <a href="cadastrar.jsp">Cadastre-se</a>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="frameworks/jquery/jquery.slim.min.js"></script>
	<script src="frameworks/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="script.js"></script>
</body>

</html>