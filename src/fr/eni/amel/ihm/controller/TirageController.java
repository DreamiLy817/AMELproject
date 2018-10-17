package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.QuestionManager;
import fr.eni.amel.bll.manager.QuestionTirageManager;
import fr.eni.amel.bo.Question;
import fr.eni.tp.web.common.bll.exception.ManagerException;

/**
 * Servlet implementation class TirageController
 */
@WebServlet("/TirageController")
public class TirageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EpreuveManager epreuveManager = ManagerFactory.epreuveManager(); 
	private QuestionManager questionManager = ManagerFactory.questionManager(); 
	private QuestionTirageManager questionTirageManager = ManagerFactory.questionTirageManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TirageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idEpreuve = request.getParameter("idEpreuve");
		int id = Integer.parseInt(idEpreuve);
		List<Question> listeQuestionsTireesAuSort = new ArrayList<Question>();
		List<Question> questions = questionManager.getQuestionEpreuve(id);
		if(questions.size() == 0)
		{
			try {
				listeQuestionsTireesAuSort = epreuveManager.tirerAuSortQuestions(id);
			} catch (ManagerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(Question question: listeQuestionsTireesAuSort) {
				questionTirageManager.insert(question.getIdQuestion(), id);	
			}
		}
		response.sendRedirect("/AMELproject/question/show");

	}

}
