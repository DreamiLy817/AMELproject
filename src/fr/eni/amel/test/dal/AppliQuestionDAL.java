package fr.eni.amel.test.dal;

import java.util.List;

import fr.eni.amel.bo.Question;
import fr.eni.amel.dal.factory.DaoFactory;

public class AppliQuestionDAL {

	public static void main(String[] args) {
		//Test d'insertion d'une question 
		
		//Test de sélection d'une question
		try{
			Question question = DaoFactory.questionDAO().selectById(1);
			System.out.println(question);
			}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		//Test de sélection de toutes les questions
		try{
			List<Question> listeQuestions = DaoFactory.questionDAO().selectAll();
			System.out.println(listeQuestions);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//Test de mise à jour d'une question
		
		//Test de suppression d'une question
		
		
		
		
	}

}
