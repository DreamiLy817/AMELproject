package fr.eni.amel.bll.manager.impl;

import fr.eni.amel.bll.manager.PromotionManager;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.dal.PromotionDao;
import fr.eni.amel.dal.factory.DaoFactory;

public class PromotionManagerImpl implements PromotionManager {
	
	private static PromotionManagerImpl instance;
	
	public static PromotionManagerImpl getInstance()
	{
		if (instance == null) {
			instance = new PromotionManagerImpl();
		}
		return instance;
	}
	
	
	
	

}
