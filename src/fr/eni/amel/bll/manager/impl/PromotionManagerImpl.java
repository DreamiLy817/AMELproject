package fr.eni.amel.bll.manager.impl;

import java.util.List;

import fr.eni.amel.bll.manager.PromotionManager;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.dal.PromotionDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class PromotionManagerImpl implements PromotionManager {
	
	private static PromotionManagerImpl instance;
	private PromotionDao promotionDAO = DaoFactory.getPromotionDao();
	
	
	public static PromotionManagerImpl getInstance()
	{
		if (instance == null) {
			instance = new PromotionManagerImpl();
		}
		return instance;
	}
	/**
	 * Pour recherche une promotion
	 * @param recherche
	 * @return
	 */

	public List<Promotion> getRecherchePromotion(String recherche) {
		List<Promotion>  listePromo = null;
		try {
			 listePromo = promotionDAO.rechercherPromotion("DL");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(listePromo);
	
		return listePromo;
			
	}
	
}
