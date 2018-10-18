package fr.eni.amel.bll.manager;

import fr.eni.amel.bo.QuestionTirage;

public interface QuestionTirageManager {

	public QuestionTirage getQuestionTirage(int idQuestion, int idEpreuve);
	
	public void insert(int idQuestion, int idEpreuve);
	
	public Long comptePointsParQuestion(int idQuestion, int idEpreuve);
}
