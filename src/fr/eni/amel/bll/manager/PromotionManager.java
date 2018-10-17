package fr.eni.amel.bll.manager;

import java.util.List;

import fr.eni.amel.bo.Promotion;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface PromotionManager {
	
	public List<Promotion> getRecherchePromotion(String recherche);
	
	public List<Promotion> getPromotions() throws ManagerException;

}
