package fr.eni.amel.test.bo;

import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.Theme;

public class AppliPropositionBO {

	public static void main(String[] args) {
		Theme theme1 = new Theme(1,"POO");
		Question question1 = new Question(1,"test question1",null,2L,theme1);
		Proposition proposition1 = new Proposition(1,"test proposition1 ",true,question1);
		System.out.println(proposition1);
		
		Proposition proposition2 = new Proposition (2,"test proposition 2", false, question1);
		System.out.println(proposition2);		

	}

}
