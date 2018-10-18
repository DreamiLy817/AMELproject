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
<title>Fin de l'épreuve</title>
</head>

<body>
	<div class="col-sm-12">
		<jsp:include page="/head" />
		<div class="col-sm-6 offset-sm-3">

			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Récapitulatif de l'épreuve</legend>
				<div class="control-group">
					<c:if test="${infoMessage != null}">
						<div class="alert alert-info mt-5">${infoMessage}</div>
					</c:if>
					<table class="table">

						<tbody>
						<c:set var="index" value="${0}"/>
							<c:forEach items="${listeQuestions}" var="questionTirage">
							<c:set var="index" value="${index+1}"/>
								<tr>
									<td>Question ${index}</td>
									<td>
									<c:if test="${questionTirage.estRepondue}">
									<input name="répondue" type="checkbox" checked disabled/>
									<label for="répondue">répondue</label></c:if>
									<c:if test="${!questionTirage.estRepondue}">
									<input name="répondue" type="checkbox" disabled />
									<label for="répondue"> non répondue</label></c:if>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<button class="btn btn-default" onclick="window.location.href='/AMELproject/epreuve/fin?action=finir-epreuve'">Finir l'épreuve</button>
				</div>
			</fieldset>
		
		</div>
	</div>
</body>
</html>