package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.UtilisateurManager;
import fr.eni.amel.bll.manager.impl.UtilisateurManagerImpl;
import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

/**
 * Servlet implementation class CandidatController
 */
@WebServlet("/CandidatController")
public class CreateUtilisateurController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUtilisateurController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			List<Profil> listeProfils = null;
			List<Promotion> listePromos = null;
			
			try {
				
				listeProfils = ManagerFactory.profilManager().getProfils();
				listePromos = ManagerFactory.promotionManager().getPromotions();
				for (Promotion promo : listePromos) {
					System.out.println(promo);
				}
				
			} catch (ManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		request.getSession().setAttribute("profils", listeProfils);
		
		request.getSession().setAttribute("promotions", listePromos);
		request.getSession().setAttribute("errorMessage", "");
		request.getSession().setAttribute("infoMessage", "");
		
		request.getRequestDispatcher("/forward/creation-utilisateur").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		UtilisateurManager utilisateurManager = UtilisateurManagerImpl.getInstance();
		// récupération des données utilisateur
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("mail");
		String password = request.getParameter("password");
		int codeProfil = Integer.parseInt(request.getParameter("profils"));
		int codePromo = Integer.parseInt(request.getParameter("promos"));
		
		Profil profil = new Profil();
		profil.setCodeProfil(codeProfil);
		Promotion promo = new Promotion();
		promo.setCodePromo(codePromo);
		// stocke dans un objet Utilisateur
		Utilisateur utilisateur = new Utilisateur(nom, prenom, email, password, profil, promo);
		
		Utilisateur utilisateurAjoute = null;
		String action = request.getParameter("action");
		
		String errorMsg = null;
		
		try {
			
			if ("create".equals(action) && utilisateur != null) {
			
				
				if (verifEmptyFieldUtilisateur(utilisateur)) {
					errorMsg = "Veuillez remplir les champs non renseignés."; 
					request.getSession().setAttribute("errorMessage", errorMsg);
					request.getRequestDispatcher("/forward/creation-utilisateur").forward(request, response);
				
				}
			}
				
			utilisateurAjoute = utilisateurManager.createUtilisateur(utilisateur);
			
			String msg = utilisateurAjoute.getPrenom() + " " + utilisateurAjoute.getNom() + " a bien été enregistré-e.";
	
			request.getSession().setAttribute("infoMessage", msg);
			response.sendRedirect("/AMELproject/utilisateur/create");
				
						
		} catch (ManagerException | FunctionalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private boolean checkProfilUtilisateurInterne(Utilisateur utilisateur) {
		boolean isInterne = false;
		
		if (utilisateur.getProfil().getCodeProfil() == 3) {
			isInterne = true;
		}
		return isInterne;
	}
	private boolean verifEmptyFieldUtilisateur(Utilisateur utilisateur) {
		
		boolean isFieldEmpty = false;
		if ((utilisateur.getPrenom() == null || utilisateur.getPrenom().trim().isEmpty())
				|| (utilisateur.getNom() == null || utilisateur.getNom().trim().isEmpty())
				|| (utilisateur.getEmail() == null || utilisateur.getEmail().trim().isEmpty())
				|| (utilisateur.getPassword() == null|| utilisateur.getPassword().trim().isEmpty())
				) {
			isFieldEmpty = true;
		} 
		
		return isFieldEmpty;
	}

}
