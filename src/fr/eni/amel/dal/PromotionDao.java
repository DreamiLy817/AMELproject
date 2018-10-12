package fr.eni.amel.dal;

import java.util.List;

import fr.eni.amel.bo.Promotion;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface PromotionDao extends GenericDAO<Promotion, Integer> {
	
	public List<Promotion> rechercherPromotion(String recherche) throws DaoException;

}
