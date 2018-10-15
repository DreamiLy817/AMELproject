package fr.eni.amel.ihm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;

public class TestController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3000379880056505185L;

	private EpreuveManager epreuveManager = ManagerFactory.epreuveManager();
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// R�cup�rer l'identifiant de l'utilisateur dans la session
		int idUtilisateur = (int) request.getSession().getAttribute("utilisateur");
		
		// Lister les tests pour l'utilisateur

		List<Epreuve> epreuves = epreuveManager.listerEpreuvesPourUtilisateur(idUtilisateur);

		request.setAttribute("epreuves", epreuves);

		request.getRequestDispatcher("/forward/tests").forward(request, response);

		// } catch (ManagerException e) {
		// LOGGER.error("Technical Error", e);
		// response.sendError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		// }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String idEpreuve = request.getParameter("idEpreuve");
//		Integer id = Integer.parseInt(idEpreuve);
		String libelleEpreuve = request.getParameter("libelleEpreuve");
		String dureeEpreuve = request.getParameter("dureeEpreuve");
		request.setAttribute("libelleEpreuve", libelleEpreuve);
		request.setAttribute("dureeEpreuve", dureeEpreuve);
		// List<Question> listeQuestionsTireesAuSort =
		// epreuveManager.tirerAuSortQuestions(id);
		// request.setAttribute("listeQuestionsTireesAuSort",
		// listeQuestionsTireesAuSort);
		request.getRequestDispatcher("/test/confirm").forward(request, response);
	}

	protected void lancerTest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idEpreuve = request.getParameter("idEpreuve");
		Integer id = Integer.parseInt(idEpreuve);
		List<Question> listeQuestionsTireesAuSort = epreuveManager.tirerAuSortQuestions(id);
		request.setAttribute("listeQuestionsTireesAuSort", listeQuestionsTireesAuSort);
		request.getRequestDispatcher("/question/show").forward(request, response);
	}
}
