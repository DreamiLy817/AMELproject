package fr.eni.amel.test.manager;

import fr.eni.amel.bll.factory.ManagerFactory;

public class AppliEpreuveManager {

	public static void main(String[] args) {
		
		//Test de la m�thode qui liste les �preuves pour un utilisateur
		//ManagerFactory.epreuveManager().listerEpreuvesPourUtilisateur(2);
		
		// Test de la m�thode qui liste 
		ManagerFactory.epreuveManager().tirerAuSortQuestions(1);
	}

}
