package fr.eni.amel.test.manager;

import fr.eni.amel.bll.factory.ManagerFactory;

public class AppliEpreuveManager {

	public static void main(String[] args) {
		
		//Test de la méthode qui liste les épreuves pour un utilisateur
		//ManagerFactory.epreuveManager().listerEpreuvesPourUtilisateur(2);
		
		// Test de la méthode qui liste 
		ManagerFactory.epreuveManager().tirerAuSortQuestions(1);
	}

}
