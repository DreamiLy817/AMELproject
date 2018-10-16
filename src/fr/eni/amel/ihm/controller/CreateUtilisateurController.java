package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.manager.ProfilManager;
import fr.eni.amel.bll.manager.PromotionManager;
import fr.eni.amel.bll.manager.impl.ProfilManagerImpl;
import fr.eni.amel.bll.manager.impl.PromotionManagerImpl;
import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.tp.web.common.bll.exception.ManagerException;

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
		ProfilManager profilManager = ProfilManagerImpl.getInstance();
		List<Profil> listeProfils = null;
		
		PromotionManager promoManager = PromotionManagerImpl.getInstance();
		List<Promotion> listePromos = null;
		try {
			listeProfils = profilManager.getProfils();
			
			listePromos = promoManager.getPromotions();
			
		} catch (ManagerException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("profils", listeProfils);
	
		request.setAttribute("promos", listePromos);
		
		request.getRequestDispatcher("/user/creation").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
