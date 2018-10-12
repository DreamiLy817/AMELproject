package fr.eni.amel.ihm.controller;

import javax.servlet.http.HttpServlet;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.UtilisateurManager;

public class AuthentificationController extends HttpServlet{

	private UtilisateurManager utilisateurManager = ManagerFactory.utilisateurManager();
	
	
}
