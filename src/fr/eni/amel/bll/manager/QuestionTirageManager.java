package fr.eni.amel.bll.manager;

import fr.eni.amel.bo.QuestionTirage;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface QuestionTirageManager {

	public QuestionTirage getQuestionTirage(int idQuestion, int idEpreuve);
	
	public void insert(int idQuestion, int idEpreuve);
	public void update(int IdQuestion, int IdEpreuve, Boolean marquee);
}
