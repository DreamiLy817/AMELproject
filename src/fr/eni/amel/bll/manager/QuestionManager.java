package fr.eni.amel.bll.manager;

import java.util.List;

import fr.eni.amel.bo.Question;

public interface QuestionManager {
	
	public Question getQuestionPropositions(Question question);
	public Question getQuestion(int id);
	public List<Question> getQuestionEpreuve(int id);
	
}
