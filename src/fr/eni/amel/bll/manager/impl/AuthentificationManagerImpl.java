package fr.eni.amel.bll.manager.impl;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.manager.AuthentificationManager;
import fr.eni.amel.bll.manager.UtilisateurManager;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.util.ValidationUtil;


public class AuthentificationManagerImpl implements AuthentificationManager {

	private UtilisateurDao utilisateurDao = DaoFactory.getUtilisateurDao();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurManager.class);
	
	private static AuthentificationManagerImpl instance;
	
	public AuthentificationManagerImpl() {
		
	}
	
	public static AuthentificationManagerImpl getInstance() {
		
		if (instance == null) {
			instance = new AuthentificationManagerImpl();
		}
		
		return instance;
	}
	
	@Override
	public Utilisateur getAuthentification(String mail, String password) throws ManagerException{
		
		
		Utilisateur utilisateur = null;
		
		try {
			
			ValidationUtil.checkNotNull(mail);
			ValidationUtil.checkNotNull(password);
			String hashPassword;
			try {
				hashPassword = PasswordTools.hashSHA256(password);
				
				utilisateur = utilisateurDao.selectByMailAndPassword(mail, hashPassword);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
		} catch (DaoException e) {
			throw new ManagerException("Message Manager", e);
			
		}
		
		return utilisateur;
	}
	
	
	
	

}
