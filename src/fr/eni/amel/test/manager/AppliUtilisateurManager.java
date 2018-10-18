package fr.eni.amel.test.manager;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

public class AppliUtilisateurManager {
	public static void main(String[] args) throws ManagerException, FunctionalException {
		// Test de la recherche d'une promotion 
		ManagerFactory.utilisateurManager().getRechercheCandidat("ri");
	}
}
