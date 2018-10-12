package fr.eni.amel.bll.manager;

import java.util.List;

import fr.eni.amel.bo.Promotion;

public interface PromotionManager {
	
	public List<Promotion> getRecherchePromotion(String recherche);

}
