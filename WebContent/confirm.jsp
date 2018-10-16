<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href='../css/bootstrap.min.css'>
<link rel="stylesheet" href='../css/style.css'>
<script src="../js/jquery-3.2.1.slim.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>Confirmation</title>
</head>

<body>
	<div class="col-sm-12">
		<jsp:include page="/head" />
		<div class="col-sm-6 offset-sm-3">
			<form action="${pageContext.request.contextPath}/question/show"
				method="post">
				<fieldset class="scheduler-border">
					<legend class="scheduler-border">Confirmation</legend>
					<div class="control-group">
						<input type="hidden" name="idEpreuve" value="${epreuve.idEpreuve}" />
						<p>Voulez-vous vraiment démarrer le test ${libelleEpreuve}?</p>
						<p>Le test durera ${dureeEpreuve} minutes.</p>

						<button class="btn btn-default" type="submit">Démarrer le
							test</button>

						<a href="${pageContext.request.contextPath}/tests/show"
							class="btn">Revenir à la liste</a>

					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>