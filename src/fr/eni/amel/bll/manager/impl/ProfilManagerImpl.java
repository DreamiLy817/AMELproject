package fr.eni.amel.bll.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.manager.ProfilManager;
import fr.eni.amel.bo.Profil;
import fr.eni.amel.dal.ProfilDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class ProfilManagerImpl implements ProfilManager {

	private ProfilDao profilDao = DaoFactory.getProfilDao();
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfilManager.class);
	
	private static ProfilManagerImpl instance;
    
    private ProfilManagerImpl() {
        
    }
    
    public static ProfilManagerImpl getInstance() {
        if(instance == null) {
            instance = new ProfilManagerImpl();
        }
        return instance;
    }
	
	/**
	 * Récupère tous les profils pour la création d'un-e utilisateurice
	 * @return une liste de profils
	 * @throws ManagerException
	 */
    @Override
	public List<Profil> getProfils() throws ManagerException {
		
		List<Profil> listeProfils = null;
		
		try {
			listeProfils = profilDao.selectAll();
		} catch (DaoException e) {
			LOGGER.error("Erreur DAO en récupérant tous les profils", e);
			throw new ManagerException("Message Manager", e);
		}

		return listeProfils;
	}

}
