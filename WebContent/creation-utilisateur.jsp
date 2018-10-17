<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<link rel="stylesheet" href="./css/style.css">
	<link rel="stylesheet" href="./css/fontawesome/css/font-awesome.min.css">
	
	<title>Creation d'un candidat</title>
</head>
<body>
	<jsp:include page="/head" />
	<div class="col-sm-12">
		<div class="col-sm-6 offset-sm-3">
			<div class="container">
				<form action="${pageContext.request.contextPath}/utilisateur/create" method="POST">
					<label for="prenom">Prénom :</label>
					<input type="text" name="prenom">
					<label for="nom">Nom :</label>
					<input type="text" name="nom">
					<label for="mail">Email :</label>
					<input type="email" name="mail">
					<label for="password">Mot de passe :</label>
					<input type="password" name="password">
					<label for="profils">Profil :</label>
					<select name="profils">
						<c:forEach items="${profils}" var="profil">
							<option value="${profil.codeProfil}">${profil.libelle}</option>
						</c:forEach>
					</select>
					<label for="promos">Promotion :</label>
					<select name="promos">
						<c:forEach items="${promotions}" var="promotion">
							<option value="${promotion.codePromo }">${promotion.libelle}</option>
						</c:forEach>
					</select>
					<button type="submit" value="valider">Valider</button>
				</form>
			</div>
 		</div>
	</div>

</body>
</html>