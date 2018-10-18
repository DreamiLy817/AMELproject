package fr.eni.amel.ihm.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.EpreuveManager;

@Path("/question/show")
public class GestionTimer {
	
	private EpreuveManager epreuveManager;
	public GestionTimer() {
		epreuveManager = ManagerFactory.epreuveManager();
	}
	
	
	@GET
	@Path("/timer")
	public void setTimer(@QueryParam(value = "idEpreuve") int idEpreuve) {
		epreuveManager.addTimer(idEpreuve);
	}
	
}
