package fr.eni.amel.ihm.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.UtilisateurManager;
import fr.eni.amel.bo.Utilisateur;

@Path("/inscription-test")
public class GestionInscriptionTest {
	
	@GET
	public List<Utilisateur> getCandidat() {
		List<Utilisateur> candidats = ManagerFactory.utilisateurManager().getAllUtilisateurs();
		return candidats;
	}
	
	@PUT
	
	
	@POST 
	
	@DELETE
	

}
