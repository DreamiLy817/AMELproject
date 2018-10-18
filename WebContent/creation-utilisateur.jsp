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
	<div class="creation-block">
		<div>
			<div class="user-creation">
				<form action="${pageContext.request.contextPath}/utilisateur/create" method="POST">
					<div class="form-group">
						<label for="prenom" class="form-text-label">Prénom :</label>
						<input type="text" class="form-text-input form-control" name="prenom">
					</div>
					<div class="form-group">
						<label for="nom" class="form-text-label">Nom :</label>
						<input type="text" class="form-text-input form-control" name="nom">
					</div>
					<div class="form-group">
						<label for="mail" class="form-text-label">Email :</label>
						<input type="email" class="form-text-input form-control" name="mail">
					</div>
					<div class="form-group">
						<label for="password" class="form-text-label">Mot de passe :</label>
						<input type="password" class="form-text-input form-control" name="password">
					</div>
					<div class="form-group">
						<label for="profils" class="form-text-label">Profil :</label>
						<select name="profils" class="form-control">
							<c:forEach items="${profils}" var="profil">
								<option value="${profil.codeProfil}">${profil.libelle}</option>
							</c:forEach>
						</select>
					</div>
					<%--  <c:if test="${profil.codeProfil == 3 }"> --%>
						<div class="form-group">
							<label for="promos" class="form-text-label">Promotion :</label>
							<select name="promos" class="form-control">
								<c:forEach items="${promotions}" var="promotion">
									<option value="${promotion.codePromo }">${promotion.libelle}</option>
								</c:forEach>
							</select>
						</div>
					<%-- </c:if> --%>
					
					<div class="d-flex justify-content-center">
						<button type="submit" class="btn btn-outline-dark" name="action" value="create">Valider</button>
					</div>
				</form>
			</div>
			<div class="message">
				<jsp:include page="/error"/>
				<c:if test="${infoMessage != null}">
					<c:remove var="errorMessage" scope="session" /> 
					<div class="alert alert-success mt-5">
						${infoMessage}
					</div>
				</c:if>
			</div>
 		</div>
	</div>

</body>
</html>