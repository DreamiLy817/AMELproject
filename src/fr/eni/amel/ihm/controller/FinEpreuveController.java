package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.QuestionTirageManager;
import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.QuestionTirage;

public class FinEpreuveController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2055016314797421827L;

	private EpreuveManager epreuveManager = ManagerFactory.epreuveManager();
	private QuestionTirageManager questionTirageManager = ManagerFactory.questionTirageManager();
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idEpreuve = Integer.parseInt((String) request.getSession().getAttribute("idEpreuve"));

		// Finir l'épreuve après validation du bouton
		if (request.getParameter("action") != null) {
			Long pointsObtenus = 0L;
			List<QuestionTirage> listeQuestions = epreuveManager.getUneEpreuve(idEpreuve).getlisteQuestionTirage();
			
			for (QuestionTirage question : listeQuestions) {
				Long pointsQuestion = questionTirageManager
						.comptePointsParQuestion(question.getQuestion().getIdQuestion(), idEpreuve);
				System.out.println(pointsQuestion);
				pointsObtenus += pointsQuestion;
				System.out.println(pointsObtenus);
			}
			request.setAttribute("points", pointsObtenus);
			request.getRequestDispatcher("results/show").forward(request, response);
		} else {
			// Récapitulatif des questions répondues ou non répondues
			List<QuestionTirage> listeQuestions = epreuveManager.getUneEpreuve(idEpreuve).getlisteQuestionTirage();
			List<QuestionTirage> listeQuestionsRepondues = new ArrayList();
			for (QuestionTirage questionTirage : listeQuestions) {
				List<Proposition> listProposition = questionTirageManager
						.getQuestionTirage(questionTirage.getQuestion().getIdQuestion(), idEpreuve).getProposition();
				if (listProposition.isEmpty()) {
					questionTirage.setEstRepondue(false);
				} else {
					questionTirage.setEstRepondue(true);
				}
				listeQuestionsRepondues.add(questionTirage);
			}
			request.setAttribute("listeQuestions", listeQuestionsRepondues);
			request.getRequestDispatcher("/forward/finEpreuve").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
