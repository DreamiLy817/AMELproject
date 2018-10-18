package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;

/**
 * Servlet implementation class InscriptionTestController
 */
@WebServlet("/InscriptionTestController")
public class InscriptionTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Test> listeTest = ManagerFactory.testManager().getListeOfTest();
		request.setAttribute("tests", listeTest);
		
		List<Utilisateur> listeCandidats;
		try {
			listeCandidats = ManagerFactory.utilisateurManager().listCandidats();
			request.setAttribute("candidats", listeCandidats);
			request.getRequestDispatcher("/forward/inscription-test").forward(request, response);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FunctionalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer idUtilisateur = Integer.parseInt(request.getParameter("candidatTrouve"));
		Integer idTest = Integer.parseInt(request.getParameter("test"));
		Date dateDebutValidite = request.getParameter("dateDebutValidite");
		Epreuve epreuve = null;
		
		try {
			 ManagerFactory.epreuveManager().insert(epreuve);
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
