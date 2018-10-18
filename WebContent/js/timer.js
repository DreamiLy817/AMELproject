/**
 * 
 */

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
  
  var seconds = totalSeconds % 60; //Recalculer les valeurs de minuterie et afficher ensuite
  var secondsTens = Math.floor(seconds / 10);
  var secondsOnes = seconds % 10;
  var minutes = Math.floor(totalSeconds / 60);
  
  document.getElementById("Timer").innerHTML = "" + minutes + ":" + secondsTens + secondsOnes;
  document.getElementById("hid_time").value = ""+ totalSeconds +"";
  }
}