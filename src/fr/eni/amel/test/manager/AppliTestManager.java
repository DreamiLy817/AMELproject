package fr.eni.amel.test.manager;

import fr.eni.amel.bll.factory.ManagerFactory;

public class AppliTestManager {
	public static void main(String[] args) {
		// Affichage de tous les tests
		ManagerFactory.testManager().getListeOfTest();
		

	}

}
