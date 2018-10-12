package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import fr.eni.amel.dal.EpreuveDAO;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

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
		
		int numero = 1;
		if (request.getParameter("no") != null) {
			numero = Integer.parseInt(request.getParameter("no"));
		}		
		
		QuestionManager questionManager =  QuestionManagerImpl.getInstance();
		List<Question> questions = questionManager.getQuestionEpreuve(1);
		
        request.setAttribute("question", questions.get(numero));
        request.setAttribute("propositions", questions.get(numero).getListePropositions());
        
        request.getRequestDispatcher("/forward/question").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
