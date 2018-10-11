package fr.eni.amel.bll.manager;

import java.util.List;

import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

public interface UtilisateurManager {

	List<Utilisateur> getAllUtilisateurs() throws ManagerException, FunctionalException;
	
	Utilisateur getUtilisateurById(Integer id) throws ManagerException, FunctionalException;
	
	Utilisateur createUtilisateur(Utilisateur utilisateur) throws ManagerException, FunctionalException;
	
	Utilisateur updateUtilisateur(Utilisateur utilisateur) throws ManagerException, FunctionalException;
	
	void deleteUtilisateur(Integer id) throws ManagerException, FunctionalException;
}
