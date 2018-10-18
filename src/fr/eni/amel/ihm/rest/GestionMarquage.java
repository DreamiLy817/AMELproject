package fr.eni.amel.ihm.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.QuestionTirageManager;
import fr.eni.amel.bo.QuestionTirage;

@Path("/question/marque")
public class GestionMarquage {
	
	private QuestionTirageManager questionTirageManager;
	
	public GestionMarquage() {
		questionTirageManager  = ManagerFactory.questionTirageManager();
	}
	
	
	@GET
	@Path("/marquage")
	public void setTimer(@QueryParam(value = "idEpreuve") int idEpreuve, @QueryParam(value = "idQuestion") int idQuestion, @QueryParam(value = "marque") String marque) {
		Boolean estMarquee = false;
		
		if(marque.equals("true"))
		{
			estMarquee = true;
		}

		questionTirageManager.update(idQuestion, idEpreuve, estMarquee);
	}
	
}
