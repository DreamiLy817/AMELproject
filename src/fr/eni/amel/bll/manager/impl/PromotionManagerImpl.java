package fr.eni.amel.bll.manager.impl;

import java.util.List;

import fr.eni.amel.bll.manager.PromotionManager;
import fr.eni.amel.bo.Promotion;

public class PromotionManagerImpl implements PromotionManager {
	
	private static PromotionManagerImpl instance;
	
	
	public static PromotionManagerImpl getInstance()
	{
		if (instance == null) {
			instance = new PromotionManagerImpl();
		}
		return instance;
	}

	public List<Promotion> getRecherchePromotion(String recherche) {
	
		return null;
			
	}
	
}
