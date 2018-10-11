package fr.eni.amel.bo;

import java.util.ArrayList;
import java.util.List;

public class QuestionTirage {
	
	private boolean estmarquee;
	private Question question;
	private Integer numordre;
	private Epreuve epreuve;
	private List<Proposition> listproposition;
	
	//Constructeur
	
	public QuestionTirage() {
		this.listproposition = new ArrayList<Proposition>();
	}
	
	public QuestionTirage(boolean estmarquee, Question question, int numordre, Epreuve epreuve,
			List listproposition) {
		this.estmarquee = estmarquee;
		this.question = question;
		this.numordre = numordre;
		this.epreuve = epreuve;
		this.listproposition = listproposition;
	}

	//Getter
	
	public boolean isEstmarquee() {
		return this.estmarquee;
	}

	public Question getQuestion() {
		return question;
	}

	public Integer getNumordre() {
		return numordre;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public List getProposition() {
		return this.listproposition;
	}
	
	
	//Setter

	public void setEstmarquee(boolean estmarquee) {
		this.estmarquee = estmarquee;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setNumordre(Integer numordre) {
		this.numordre = numordre;
	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	public void setListProposition(List listproposition) {
		this.listproposition = listproposition;
	}
	
	//array List
		
	public Proposition getUneProposition(Integer index)
	{
		return this.listproposition.get(index);
	}
	
	public void addProposition(Proposition proposition)
	{
		this.listproposition.add(proposition);
	}
	

}
