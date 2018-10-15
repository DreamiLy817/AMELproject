<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Question ${numero +1}</title>
	</head>
	<body>
		<div class="row">
			<div class="col-md-3">
				Navigation :
				<c:forEach var="i" begin="0" end="${nbQuestion}" step="1">
					<a href="${pageContext.request.contextPath}/question/show?no=${i}">${i + 1 }</a>
				</c:forEach>
			</div>
			<div class="col-md-6">
				<form action="${pageContext.request.contextPath}/reponse/save" method="Post">
					<div class="row">
						Questions ${numero +1} : ${question.enonce}
					</div>	
					<c:forEach items="${question.listePropositions}" var="proposition">
						<div class="form-check">
						    <input type="checkbox" class="form-check-input" id="Check${proposition.idProposition}" name="Check${proposition.idProposition}" value="1"
						    	<c:if test = "${proposition.estCoche}">
        							checked
      							</c:if>
      						>
						    <label class="form-check-label" for="Check${proposition.idProposition}">${proposition.enonce}</label>
						</div>
					</c:forEach>
					<input type="hidden" id="hid_idQuestion" name="hid_idQuestion" value="${question.idQuestion}">
					<input type="hidden" id="hid_idEpreuve" name="hid_idEpreuve" value="${idEpreuve}">
					<input type="hidden" id="hid_no" name="hid_no" value="${numero}">
					<input type="submit" class="form-submit-input" value="valider">
				</form>
			</div>
		</div>
	</body>
</html>