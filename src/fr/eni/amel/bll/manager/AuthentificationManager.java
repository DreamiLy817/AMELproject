package fr.eni.amel.bll.manager;

import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

public interface AuthentificationManager {

	public Utilisateur getAuthentification(String mail, String password) throws ManagerException, FunctionalException;
	
	
}
