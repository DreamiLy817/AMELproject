package fr.eni.amel.bo;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Proposition {

	private Integer idProposition;
	private String enonce;
	private Boolean estBonne;
	private Question question;
	private Boolean estCoche;

	public Proposition() {

	}

	public Proposition(Integer idProposition, String enonce, Boolean estBonne, Question question) {
		super();
		this.idProposition = idProposition;
		this.enonce = enonce;
		this.estBonne = estBonne;
		this.question = question;
	}

	public Integer getIdProposition() {
		return idProposition;
	}

	public void setIdProposition(Integer idProposition) {
		this.idProposition = idProposition;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public Boolean getEstBonne() {
		return estBonne;
	}

	public void setEstBonne(Boolean estBonne) {
		this.estBonne = estBonne;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Boolean getEstCoche() {
		return this.estCoche; 
	}
	
	public void setEstCoche(Boolean coche) {
		this.estCoche = coche;
	}
	
	@Override
	public String toString() {
		return String.format("Proposition [idProposition=%s, enonce=%s, estBonne=%s, question=%s]", idProposition,
				enonce, estBonne, question+"\n");
	}

}
