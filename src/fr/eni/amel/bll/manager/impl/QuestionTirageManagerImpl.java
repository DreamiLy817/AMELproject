package fr.eni.amel.bll.manager.impl;

import fr.eni.amel.bll.manager.QuestionTirageManager;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class QuestionTirageManagerImpl implements QuestionTirageManager {

	private static QuestionTirageManagerImpl instance;
	
	public static QuestionTirageManagerImpl getInstance()
	{
		if(instance == null)
		{
			instance = new QuestionTirageManagerImpl();
		}
		return instance;
	}
	
	
	public QuestionTirage getQuestionTirage(int idQuestion, int idEpreuve){
		
		try {
			return (QuestionTirage)DaoFactory.questiontirageDAO().selectById(idQuestion, idEpreuve);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
