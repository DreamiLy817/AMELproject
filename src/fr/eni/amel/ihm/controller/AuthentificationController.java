package fr.eni.amel.ihm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.manager.AuthentificationManager;
import fr.eni.amel.bll.manager.impl.AuthentificationManagerImpl;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.HttpStatus;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
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
		// récupère le message d'erreur défini dans la méthode doPost()
		request.setAttribute("errorMessage", request.getSession().getAttribute("errorMessage"));
		request.getRequestDispatcher("/authentification").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AuthentificationManager authentificationManager = AuthentificationManagerImpl.getInstance();
		
		String mail = request.getParameter("identifiant");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		
		String errorMsg = null;
		
		try {
			Utilisateur utilisateur = authentificationManager.getAuthentification(mail, password);
			// vérif si authentification correct
			if (utilisateur != null) {
				request.getSession().setAttribute("utilisateur", utilisateur.getIdUtilisateur());
				
				// redirige vers page de tests
				//request.getRequestDispatcher("/tests/show").forward(request, response);
				response.sendRedirect("/AMELproject/tests/show");
				
			// vérif si bouton "login" enclenché ET si tous les champs sont remplis
			} else if ("login".equals(action)
					&& ((mail.equals(null) || mail.trim().isEmpty())
					|| (password == null || password.trim().isEmpty()))) {
				errorMsg = "Veuillez saisir tous les champs d'authentification";
				request.getSession().setAttribute("errorMessage", errorMsg);
				request.getRequestDispatcher("/authentification").forward(request, response);
			} else {
				// redirige vers l'authentification
				errorMsg = "Vos identifiants sont incorrects."; 
				request.getSession().setAttribute("errorMessage", errorMsg);
				request.getRequestDispatcher("/authentification").forward(request, response);
				
			}
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

}
