package fr.eni.amel.ihm.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.amel.dal.factory.DaoFactory;

@Path("/inscription-test")
public class GestionInscriptionTest {
	private UtilisateurDao userDAO;
	public GestionInscriptionTest() {
		userDAO = DaoFactory.getUtilisateurDao();
	}
	
	
	@GET
	public List<Utilisateur> getCandidats() {
		List<Utilisateur> candidats = ManagerFactory.utilisateurManager().getAllUtilisateurs();
		return candidats;
	}

	@PUT
//	@Path("/{id:\\d+}")
//	public void modifierCandidat(int id) {
//		
//		Utilisateur candidat = ManagerFactory.utilisateurManager().updateUtilisateur(id);
//	
//		
//	}
	
	
	@POST 
	
	@DELETE
	

}
