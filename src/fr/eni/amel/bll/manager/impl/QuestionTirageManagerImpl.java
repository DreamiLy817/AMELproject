package fr.eni.amel.bll.manager.impl;

import java.util.List;

import fr.eni.amel.bll.factory.ManagerFactory;
import fr.eni.amel.bll.manager.QuestionManager;
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
	
	public void insert(int idQuestion, int idEpreuve){
		
		int ordre = 0;
		
		try {
			DaoFactory.questiontirageDAO().insert(idQuestion, idEpreuve, ordre);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void update(int IdQuestion, int IdEpreuve, Boolean marquee) {
		try {
			DaoFactory.questiontirageDAO().update(IdQuestion, IdEpreuve, marquee);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
