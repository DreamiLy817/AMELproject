package fr.eni.amel.dal;

import java.util.List;

import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface UtilisateurDao extends GenericDAO<Utilisateur, Integer> {
	
	/**
	 * Sélectionne un-e utilisateurice par son email et son mot de passe
	 * @param mail
	 * @param password
	 * @return Utilisateur
	 * @throws DaoException
	 */
	public Utilisateur selectByMailAndPassword(String mail, String password) throws DaoException;

	public List<Utilisateur> rechercherCandidat(String recherche) throws DaoException;
	
}
