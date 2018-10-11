package fr.eni.amel.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bll.manager.QuestionManager;
import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class QuestionManagerImpl implements QuestionManager{

	
		public Question getQuestionPropositions(Question question){
			
			try {
				question.setListePropositions(DaoFactory.propositionDAO().listePropositionsParQuestion(question.getIdQuestion()));
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return question;
		}
}
