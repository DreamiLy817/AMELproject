package fr.eni.amel.test.manager;

import fr.eni.amel.bll.factory.PromotionFactory;

public class AppliPromoManager {

	public static void main(String[] args) {
		// Test de la recherche d'une promotion 
		PromotionFactory.promotionManager().getRecherchePromotion("Le");
		

	}

}
