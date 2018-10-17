package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Utilisateur;

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
		
		List<Utilisateur> listeCandidats = ManagerFactory.utilisateurManager().getRechercheCandidat("");
		request.setAttribute("candidats", listeCandidats);
		request.getRequestDispatcher("/forward/inscription-test").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer idUtilisateur = Integer.parseInt(request.getParameter("candidatTrouve"));
		Integer idTest = Integer.parseInt(request.getParameter("test"));
		
		}
}
