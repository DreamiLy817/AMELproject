package fr.eni.amel.bll.manager;

import fr.eni.amel.bo.Utilisateur;

public interface AuthentificationManager {

	public Utilisateur getAuthentification(String mail, String password);
	
	
}
