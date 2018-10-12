package fr.eni.amel.bll.manager;

import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface AuthentificationManager {

	public Utilisateur getAuthentification(String mail, String password) throws ManagerException;
	
	
}
