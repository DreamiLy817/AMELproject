package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.manager.PropositionManager;
import fr.eni.amel.bll.manager.QuestionTirageManager;
import fr.eni.amel.bll.manager.impl.PropositionManagerImpl;
import fr.eni.amel.bll.manager.impl.QuestionTirageManagerImpl;
import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.QuestionTirage;

/**
 * Servlet implementation class ReponseController
 */
@WebServlet("/ReponseController")
public class ReponseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReponseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.getRequestDispatcher("/forward/question").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idEpreuve = Integer.parseInt(request.getParameter("hid_idEpreuve"));
		int idQuestion = Integer.parseInt(request.getParameter("hid_idQuestion"));
		int numero = Integer.parseInt(request.getParameter("hid_no")) + 1;
		QuestionTirageManager questionTirageManager =  QuestionTirageManagerImpl.getInstance();
		QuestionTirage questionTirage = questionTirageManager.getQuestionTirage(idQuestion ,idEpreuve);
		Question question = questionTirage.getQuestion();

		List<Proposition> propositions = question.getListePropositions();
		List<Proposition> propositionsCochee = new ArrayList<Proposition>();

		
		for(Proposition proposition: propositions) {
			if(request.getParameter("Check"+proposition.getIdProposition()) != null)
			{
				if(request.getParameter("Check"+proposition.getIdProposition()).equals("1"))
				{
					propositionsCochee.add(proposition);
				}
			}
		}
		PropositionManager propositionManager =  PropositionManagerImpl.getInstance();
		propositionManager.Repondre(questionTirage, propositionsCochee);
		 //request.getRequestDispatcher("/question/show").forward(request, response);
		response.sendRedirect("/AMELproject/question/show?no="+ numero);
	}

}
