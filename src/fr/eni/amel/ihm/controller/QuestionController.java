package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.PropositionManager;
import fr.eni.amel.bll.manager.QuestionManager;
import fr.eni.amel.bll.manager.QuestionTirageManager;
import fr.eni.amel.bll.manager.impl.DateManagerImpl;
import fr.eni.amel.bll.manager.impl.EpreuveManagerImpl;
import fr.eni.amel.bll.manager.impl.PropositionManagerImpl;
import fr.eni.amel.bll.manager.impl.QuestionManagerImpl;
import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.bo.Test;

/**
 * Servlet implementation class QuestionController
 */
@WebServlet("/QuestionController")
public class QuestionController extends HttpServlet {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = -2170620712623229221L;

	/**
	 * 
     * @see HttpServlet#HttpServlet()
     */
    public QuestionController() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!verifier_acces(request))
		{
			response.sendRedirect("/AMELproject/tests/show");
			return;
		}
		else
		{
			int idEpreuve = Integer.parseInt((String)request.getSession().getAttribute("idEpreuve"));
			
			EpreuveManager epreuveManager =  ManagerFactory.epreuveManager();
			Epreuve epreuve = epreuveManager.getUneEpreuve(idEpreuve);
			
			
			int numero = 0;
			if (request.getParameter("no") != null) {
				numero = Integer.parseInt(request.getParameter("no"));
			}
			
			QuestionManager questionManager =  ManagerFactory.questionManager();
			List<Question> questions = questionManager.getQuestionEpreuve(idEpreuve);
			
			if(numero > questions.size()-1 || numero < 0)
			{
				numero = 0;
			}
			
			if(questions.size() > 0 )
			{
				PropositionManager propositionManager =  ManagerFactory.propositionManager();
				List<Proposition> listPropositionsCoche = propositionManager.getReponseCochee(idEpreuve, questions.get(numero).getIdQuestion());
				
				List<Proposition> newlist = new ArrayList<Proposition>(); 
				
				for(Proposition proposition: questions.get(numero).getListePropositions()) {
					
					for(Proposition prop: listPropositionsCoche) {
						
						if(prop.getIdProposition() == proposition.getIdProposition())
						{
							proposition.setEstCoche(true);
						}
					}
					
					newlist.add(proposition);
					
				}
				
				questions.get(numero).setListePropositions(newlist);
				request.setAttribute("numero", numero);
		        request.setAttribute("question", questions.get(numero));
		        request.setAttribute("epreuve", epreuve);
		        request.setAttribute("allQuestions", questions);
		        request.getRequestDispatcher("/forward/question").forward(request, response);
			}
			else
			{
				response.sendRedirect("/AMELproject/tests/show");
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Boolean verifier_acces(HttpServletRequest request)
	{
		if(request.getSession().getAttribute("idEpreuve") != null)
		{
			int idEpreuve = Integer.parseInt((String)request.getSession().getAttribute("idEpreuve"));
			EpreuveManager epreuveManager = EpreuveManagerImpl.getInstance();
			Epreuve epreuve = epreuveManager.getUneEpreuve(idEpreuve);
			
			if(DateManagerImpl.isBeforeDay(new Date(), epreuve.getDateFinValidite()) && DateManagerImpl.isAfterDay(epreuve.getDateFinValidite(), new Date()))
			{
				Test test = epreuve.getTest();
				if(epreuve.getTempsEcoule() < test.getDuree())
				{
					return true;
				}
			}
		}
		
		return false;
	}

}
