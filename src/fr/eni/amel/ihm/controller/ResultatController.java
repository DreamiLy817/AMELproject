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
import fr.eni.tp.web.common.bll.exception.ManagerException;

public class ResultatController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4794810569397996688L;

	private EpreuveManager epreuveManager = ManagerFactory.epreuveManager();
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// R�cup�rer l'identifiant de l'utilisateur dans la session

		int idUtilisateur = (int) request.getSession().getAttribute("utilisateur");
		List<Epreuve> epreuves;
		try {
			epreuves = epreuveManager.listerEpreuvesPourUtilisateur(idUtilisateur, false);
			request.setAttribute("epreuves", epreuves);
			if (epreuves.isEmpty()) {
				request.setAttribute("infoMessage", "il n'y a pas d'épreuves pour l'instant");
			}
			request.getRequestDispatcher("/forward/results").forward(request, response);
		} catch (ManagerException e) {
			LOGGER.info("erreur survenue pendant affichage des épreuves d'un utilisateur");
			request.setAttribute("error", e);
			response.sendRedirect("/AMELproject/technicalError");
		}
	}
}
