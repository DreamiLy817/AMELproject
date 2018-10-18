package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.QuestionManager;
import fr.eni.amel.bll.manager.impl.EpreuveManagerImpl;
import fr.eni.amel.bll.manager.impl.QuestionManagerImpl;
import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;

/**
 * Servlet implementation class FinEpreuveController
 */
@WebServlet("/FinEpreuveController")
public class FinEpreuveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinEpreuveController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idEpreuve = Integer.parseInt((String)request.getSession().getAttribute("idEpreuve"));
		EpreuveManager epreuveManager = EpreuveManagerImpl.getInstance();
		Epreuve epreuve = epreuveManager.getUneEpreuve(idEpreuve);
		
		QuestionManager questionManager =  QuestionManagerImpl.getInstance();
		List<Question> questions = questionManager.getQuestionEpreuve(idEpreuve);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
