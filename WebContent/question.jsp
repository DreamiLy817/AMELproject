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
	<jsp:include page="/head" />
		<div class="row">
			<div class="col-md-2 offset-md-1">
				<div class="row">
					Navigation :<br/>
					<c:set var = "i" value = "0"/>
					<c:forEach  items="${allQuestions}" var="Unequestion">
						 	&nbsp;<a href="${pageContext.request.contextPath}/question/show?no=${i}" <c:if test = "${Unequestion.estMarquee}"> style="color : red;" </c:if> >${i + 1 }</a>
						 	<c:set var = "i" value = "${i + 1}"/>
					</c:forEach>
				</div>
				<div class="row" style="margin-top:30px;">
					<div class="form-check">
						<input type="checkbox" id="chx_marquer" name="chx_marquer" onchange="MarquageFunction();"  
						 <c:if test = "${question.estMarquee}">
        							checked
      					</c:if>
      					/>
						 <label class="form-check-label" for="chx_marquer">
      					Marquer</label>
					</div>
				</div>
				<div class="row" style="margin-top:30px;">
					<label id="Timer" class="form-check-label" for="chx_marquer"></label>
				</div>
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
					<input type="hidden" id="hid_idEpreuve" name="hid_idEpreuve" value="${epreuve.idEpreuve}">
					<input type="hidden" id="hid_no" name="hid_no" value="${numero}">
					<input type="hidden" id="hid_time" name="hid_time" value="${epreuve.test.duree - epreuve.tempsEcoule}">
					<input type="submit" class="form-submit-input" value="valider">
				</form>
			</div>
		</div>
		<script>		
		  var totalSeconds; //Nombre total de secondes sur le minuteur
		  var temps = document.getElementById("hid_time").value;
		  var minute = 0;
		  
		  function StartTimer()
		  {
		    totalSeconds = temps * 60; //Défini le nombre de secondes restantes
		    
		    setInterval("Timer_Tick()", 1000);// Démarrer le minuteur, régler pour s'éteindre toutes les secondes
		    
		    var seconds = totalSeconds % 60; //calculer les secondes restantes
		    var secondsTens = Math.floor(seconds / 10);
		    var secondsOnes = seconds % 10;
		    var minutes = Math.floor(totalSeconds / 60);
		    
		    document.getElementById("Timer").innerHTML = "" + minutes + ":" + secondsTens + secondsOnes; //montre minuterie  
		  }
		  		
		  		
		  function Timer_Tick()
		  {
		    if (totalSeconds > 0) // S'il reste du temps ...
		    {
		      	totalSeconds--; // Décrémenter le nombre total de secondes
		      	minute ++;
			    var seconds = totalSeconds % 60; //Recalculer les valeurs de minuterie et afficher ensuite
			    var secondsTens = Math.floor(seconds / 10);
			    var secondsOnes = seconds % 10;
			    var minutes = Math.floor(totalSeconds / 60);
			    document.getElementById("Timer").innerHTML = "" + minutes + ":" + secondsTens + secondsOnes;
			    document.getElementById("hid_time").value = ""+ totalSeconds +"";
			    if(minute > 59)
			    {
			     	timerFunction();
			    	minute = 0;
			    }
		    }
		  }
		  
		  window.onload = StartTimer();
		  
		  function timerFunction() {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
					var info = xhttp.responseText;

					}
				};
				var updateTimer = "http://localhost:8080/AMELproject/rest/question/show/timer?idEpreuve=" + document.getElementById("hid_idEpreuve").value;
				xhttp.open(
								"GET",
								updateTimer,
								true);
				xhttp.send();
			}
		  
		  function MarquageFunction() {
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
					var info = xhttp.responseText;

					}
				};
				var checked = document.getElementById("chx_marquer").checked;
				var updateCheck = "http://localhost:8080/AMELproject/rest/question/marque/marquage?idEpreuve=" + document.getElementById("hid_idEpreuve").value + "&idQuestion=" + document.getElementById("hid_idQuestion").value + "&marque="+checked;
				xhttp.open(
								"GET",
								updateCheck,
								true);
				xhttp.send();
			}
		  
		  
		</script>
	</body>
</html>