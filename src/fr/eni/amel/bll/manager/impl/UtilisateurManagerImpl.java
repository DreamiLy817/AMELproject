package fr.eni.amel.bll.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.manager.UtilisateurManager;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.exception.FunctionalException;
import fr.eni.tp.web.common.util.ValidationUtil;

public class UtilisateurManagerImpl implements UtilisateurManager{
	
	private UtilisateurDao utilisateurDao = DaoFactory.getUtilisateurDao();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurManager.class);
	
	private static UtilisateurManagerImpl instance;
    
    private UtilisateurManagerImpl() {
        
    }
    
    public static UtilisateurManagerImpl getInstance() {
        if(instance == null) {
            instance = new UtilisateurManagerImpl();
        }
        return instance;
    }

    /**
     * Récupère une liste d'utilisateurices
     * @return liste Utilisateur
     */
	@Override
	public List<Utilisateur> getAllUtilisateurs() throws ManagerException, FunctionalException {
		
		List<Utilisateur> listeUtilisateurs = null;
		
		try {
			listeUtilisateurs = utilisateurDao.selectAll();
			
		} catch (DaoException e) {
			LOGGER.error("Erreur DAO en récupérant la liste d'utilisateurices", e);
			
			throw new ManagerException(e.getMessage(), e);
		}
		return listeUtilisateurs;
	}
	
	/**
	 * Récupère un-e utilisateurice par son identifiant
	 * @return Utilisateur
	 */
	@Override
	public Utilisateur getUtilisateurById(Integer id) throws ManagerException, FunctionalException {

		Utilisateur utilisateur = null;
		
		try {
			
			ValidationUtil.checkNotNull(id);
			
			utilisateur = utilisateurDao.selectById(id);
			
			if (utilisateur == null) {
				throw new ElementNotFoundException("Cet-te utilisateurice n'existe pas ou n'est plus enregistré-e.", null);
			}
			
		} catch (DaoException e) {
			
			LOGGER.error("Erreur DAO en récupérant l'utilisateurice",e);
			throw new ManagerException(e.getMessage(), e);
			
		} catch (IllegalArgumentException e) {
			
			LOGGER.error("L'id " + id + " est null", e);
			throw new ManagerException("L'id ne peut être null", e);
		}
		
		return utilisateur;
	}

	/**
	 * Ajoute un-e utilisateurice
	 * @return Utilisateur
	 */
	@Override
	public Utilisateur createUtilisateur(Utilisateur utilisateur) throws ManagerException, FunctionalException {
		
		
		 try {

	            ValidationUtil.checkNotNull(utilisateur);
//	            ValidationUtil.checkNotNull(utilisateur.getIdUtilisateur());

	            try {
	                ValidationUtil.checkNotBlank(utilisateur.getNom());
	                ValidationUtil.checkNotBlank(utilisateur.getPrenom());
	                ValidationUtil.checkNotNull(utilisateur.getEmail());
	                ValidationUtil.checkNotBlank(utilisateur.getEmail());
	                ValidationUtil.checkNotBlank(utilisateur.getPassword());
	                ValidationUtil.checkNotNull(utilisateur.getPassword());
	                
	                ValidationUtil.checkNotBlank(utilisateur.getProfil().getLibelle());
	                ValidationUtil.checkNotNull(utilisateur.getProfil().getLibelle());
	                //ValidationUtil.checkNotBlank(utilisateur.getPromo().getLibelle());
	                
	            } catch (Exception e) {
	                throw new FunctionalException("The name cannot be blank", null);
	            }
	           

	            utilisateurDao.insert(utilisateur);

	        } catch (DaoException e) {
	        	LOGGER.error("Erreur DAO en créant l'utilisateurice", e);
	            throw new ManagerException(e.getMessage(), e);

	        } catch (IllegalArgumentException e) {
	        	LOGGER.error("L'utilisateur n'est pas valide car null", e);
	            throw new ManagerException("L'utilisateurice ne peut être null", e);
	        }
	        
	        return utilisateur;
	}

	/**
	 * Met à jour un-e utilisateurice
	 * @return Utilisateur
	 */
	@Override
	public Utilisateur updateUtilisateur(Utilisateur utilisateur) throws ManagerException, FunctionalException {

		try{
			
			ValidationUtil.checkNotNull(utilisateur);
			
			utilisateurDao.update(utilisateur);

	     } catch (DaoException e) {
	     	
	    	 LOGGER.error("Erreut DAO en modifiant l'utilisateurice", e);
	        throw new ManagerException(e.getMessage(), e);

		} catch (IllegalArgumentException e) {
			LOGGER.error("L'utilisateurice est null", e);
			throw new ManagerException("L'utilisateurice ne peut être null", e);
		}
		return null;
	}

	/**
	 * Supprime un-e utilisateurice
	 */
	@Override
	public void deleteUtilisateur(Integer id) throws ManagerException, FunctionalException {
		
		try {

			ValidationUtil.checkNotNull(id);
			
			utilisateurDao.delete(id);
			
		} catch (DaoException e) {
			
			LOGGER.error("Erreur DAO en supprimant cet-te utilisateurice", e);
            throw new ManagerException(e.getMessage(), e);
            
        } catch (IllegalArgumentException e) {
        	
        	LOGGER.error("L'id " + id + "est null", e);
        	throw new ManagerException("L'id ne peut être null", e);
        }
		
		
		
	}
}
