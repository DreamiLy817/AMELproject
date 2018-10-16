package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.QuestionTirageManager;
import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;

/**
 * Servlet implementation class TirageController
 */
@WebServlet("/TirageController")
public class TirageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private EpreuveManager epreuveManager = ManagerFactory.epreuveManager();  
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

		String idEpreuve = request.getParameter("idEpreuve");
		Integer id = Integer.parseInt(idEpreuve);
		List<Question> listeQuestionsTireesAuSort = epreuveManager.tirerAuSortQuestions(id);
		
		request.setAttribute("listeQuestionsTireesAuSort", listeQuestionsTireesAuSort);
		request.setAttribute("epreuve", idEpreuve);
		request.getRequestDispatcher("/question/show").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
