<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/fontawesome/css/font-awesome.min.css">

<title>Inscriptions aux tests</title>
</head>
<body id="inscription-test">
	<div class="container">
		<h1>Inscriptions aux tests</h1>
		<div class="parametre-block">
			<div class="selection-block">
				<form>
					<p>Sélectionner le test</p>
					<select class="custom-select mr-sm-2">
						<c:forEach items="${tests}" var="test">
							<option value="${test.idTest}">${test.libelle}</option>
						</c:forEach>
					</select>
				</form>
				<form>
					<div class="form-group">
						<label for="dateDebutValidite"> Du</label> <input type="date"
							class="form-control" id="dateDebutValidite">
					</div>
					<div class="form-group">
						<label for="dateFinValidite"> Au:</label> <input type="date"
							class="form-control" id="dateFinValidite">
					</div>
				</form>
			</div>
		</div>
		<div class="search-block">
			<p>Rechercher les candidats</p>
			<form action="${pageContext.request.contextPath}/login/validerAcces"
				method="post">
				<div class="input-group stylish-input-group">
					<input type="text" class="form-control" placeholder="Search">
					<span class="input-group-addon">
						<button type="submit">ok</button>
					</span>
				</div>
			</form>
		</div>
		<div class="candidat-block">
			<div class="candidatTrouve-block">
				<form>
					<div class="form-group">
						<label for="candidatTrouve">Candidats</label> <select
							multiple class="form-control" id="candidatTrouve">
							<c:forEach items="${candidats}" var="candidat">
						<option value="${candidat.idUtilisateur}">${candidat.prenom} ${candidat.nom}</option>
					</c:forEach>
						</select>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>