package fr.eni.amel.bll.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.manager.ProfilManager;
import fr.eni.amel.bll.manager.PromotionManager;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.dal.PromotionDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class PromotionManagerImpl implements PromotionManager {
	
	private static PromotionManagerImpl instance;
	private PromotionDao promotionDAO = DaoFactory.getPromotionDao();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfilManager.class);
	
	
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
		List<Promotion>  listePromos = null;
		try {
			 listePromos = promotionDAO.rechercherPromotion(recherche);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listePromos;
			
	}
	
	/**
	 * Récupère toutes les promotions pour la création d'un-e utilisateurice
	 * @return une liste de promotion
	 * @throws ManagerException
	 */
	@Override
	public List<Promotion> getPromotions() throws ManagerException {
		List<Promotion> listePromos = null;
		
		try {
			listePromos = promotionDAO.selectAll();
		} catch (DaoException e) {
			LOGGER.error("Erreur DAO en récupérant toutes les promotions", e);
			throw new ManagerException("Message Manager", e);
		}
		return listePromos;
	}
	
	
}
