<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='../css/bootstrap.min.css'>
<link rel="stylesheet" href='../css/style.css'>
<script src="../js/jquery-3.2.1.slim.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>Liste des tests</title>
</head>

<body>
	<div class="col-sm-12">
		<div class="col-sm-6 offset-sm-3">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Tests à effectuer</legend>
				<div class="control-group">
					<c:forEach items="${epreuves}" var="epreuve">
						<form action="${pageContext.request.contextPath}/tests/show" method="post">
							<input type="hidden" name="idEpreuve" value="${epreuve.idEpreuve}"/>
							<input type="hidden" name="libelleEpreuve" value="${ epreuve.test.libelle}"/>
							<input type="hidden" name="dureeEpreuve" value="${epreuve.test.duree }"/>
							<button class="btn btn-default" type="submit">${epreuve.test.libelle}-
								Durée du test: ${epreuve.test.duree} minutes</button>
						</form>
					</c:forEach>
				</div>
			</fieldset>
		</div>
	</div>
</body>
</html>