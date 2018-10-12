package fr.eni.amel.ihm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.manager.AuthentificationManager;
import fr.eni.amel.bll.manager.impl.AuthentificationManagerImpl;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.HttpStatus;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.exception.FunctionalException;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class AuthentificationController
 */
@WebServlet("/AuthentificationController")
public class AuthentificationController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6459106564238636249L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthentificationController.class);
	
	/**
	 * 
     * @see HttpServlet#HttpServlet()
     */
	public AuthentificationController() {
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthentificationManager authentificationManager = AuthentificationManagerImpl.getInstance();
		
		String mail = request.getParameter("identifiant");
		String password = request.getParameter("password");
		
		Utilisateur utilisateur = authentificationManager.getAuthentification(mail, password);
		
		if (utilisateur != null) {
			request.setAttribute("utilisateur", utilisateur.getIdUtilisateur());
			
			// redirige vers page de tests
			request.getRequestDispatcher("/tests/show").forward(request, response);
		} else {
			// redirige vers l'authentification
			request.getRequestDispatcher("/authentification").forward(request, response);
		}
		
	}

}
