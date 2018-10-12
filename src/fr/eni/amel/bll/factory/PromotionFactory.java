package fr.eni.amel.bll.factory;

import fr.eni.amel.bll.manager.PromotionManager;
import fr.eni.amel.bll.manager.impl.PromotionManagerImpl;

public class PromotionFactory {
	
	public static PromotionManager promotionManager() {
		return PromotionManagerImpl.getInstance();
	}
}
