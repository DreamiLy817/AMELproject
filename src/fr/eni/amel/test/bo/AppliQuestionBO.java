package fr.eni.amel.test.bo;

import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.Theme;

public class AppliQuestionBO {

	public static void main(String[] args) {
		
		// Test question sans propositions
		
		Theme theme1 = new Theme(1,"POO");                                       
		Question question1 = new Question(1,"Test question1 sans propositions",null,2L,theme1);
		System.out.println(question1);
		
		//Test question avec propositions
		
		Proposition proposition1 = new Proposition(1,"test proposition1 ",true,question1);
	
		Proposition proposition2 = new Proposition (2,"test proposition 2", false, question1);
		
		List<Proposition> listeProposition = new ArrayList();
		listeProposition.add(proposition1);
		listeProposition.add(proposition2);
		question1 = new Question(1,"Test question1 avec liste de propositions",null,2L, theme1,listeProposition);
		System.out.println(question1);
		
	}

}
