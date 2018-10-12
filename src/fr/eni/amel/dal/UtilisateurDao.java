package fr.eni.amel.dal;

import java.util.List;

import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface UtilisateurDao extends GenericDAO<Utilisateur, Integer> {
	
	public List<Utilisateur> rechercherCandidat(String recherche) throws DaoException;
	
}
