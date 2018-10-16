package fr.eni.amel.test.manager;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class AppliEpreuveManager {

	public static void main(String[] args) {
		
		//Test de la m�thode qui liste les �preuves pour un utilisateur
		//ManagerFactory.epreuveManager().listerEpreuvesPourUtilisateur(2);
		
		// Test de la m�thode qui liste 
		try {
			ManagerFactory.epreuveManager().tirerAuSortQuestions(1);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
