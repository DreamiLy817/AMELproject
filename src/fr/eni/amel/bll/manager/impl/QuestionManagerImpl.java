package fr.eni.amel.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bll.manager.QuestionManager;
import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.dal.EpreuveDAO;
import fr.eni.amel.dal.QuestionDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class QuestionManagerImpl implements QuestionManager{

		private static QuestionManagerImpl instance;
		
		public static QuestionManagerImpl getInstance()
		{
			if(instance == null)
			{
				instance = new QuestionManagerImpl();
			}
			return instance;
		}
	
		public Question getQuestionPropositions(Question question){
			
			try {
				question.setListePropositions(DaoFactory.propositionDAO().listePropositionsParQuestion(question.getIdQuestion()));
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return question;
		}
		
		public Question getQuestion(int id){
			
			try {
				return DaoFactory.questionDAO().selectById(id);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
			
		}
		
		public List<Question> getQuestionEpreuve(int idEpreuve){
			
			List<Question> questions = new ArrayList<Question>();
			EpreuveDAO epreuveDao = DaoFactory.epreuveDAO();
			Epreuve epreuve = null;
			try {
				epreuve = epreuveDao.selectById(idEpreuve);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<QuestionTirage> listTirage = epreuve.getlisteQuestionTirage();
			
			QuestionDao questionDao = DaoFactory.questionDAO();
			
			for(QuestionTirage laQuestion: listTirage) {
				questions.add(laQuestion.getQuestion());		
			}
			
			return questions;
			
		}
}
