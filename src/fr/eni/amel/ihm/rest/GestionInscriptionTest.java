package fr.eni.amel.ihm.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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
	@Path("/candidats")
	public List<Utilisateur> getCandidats(@QueryParam(value = "recherche") String recherche) {
	
		List<Utilisateur> candidats = ManagerFactory.utilisateurManager().getRechercheCandidat(recherche);
		return candidats;
	}
	
	@GET 
	@Path("/{Test: \\d+}")
	// recupérer la liste des candidats qui sont ne sont pas inscrit au test selectionné
	public List<Utilisateur> getCandidatsByTest(@QueryParam(value = "idTest") int idTest, @QueryParam(value = "saisieRecherche") String saisieRecherche ) {
		return null;
		
	}
}
