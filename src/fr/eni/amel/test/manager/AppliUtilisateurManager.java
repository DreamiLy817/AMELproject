package fr.eni.amel.test.manager;

import fr.eni.amel.bll.factory.ManagerFactory;

public class AppliUtilisateurManager {
	public static void main(String[] args) {
		// Test de la recherche d'une promotion 
		ManagerFactory.utilisateurManager().getRechercheCandidat("ri");
	}
}
