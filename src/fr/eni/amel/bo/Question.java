package fr.eni.amel.bo;

import java.util.ArrayList;
import java.util.List;

public class Question {

	private Integer idQuestion;
	private String enonce;
	private String media;
	private Long points;
	private Theme theme;
	private List<Proposition> listePropositions = new ArrayList<Proposition>();

	public Question() {

	}

	public Question(Integer idQuestion, String enonce, String media, Long points, Theme theme) {
	
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.media = media;
		this.points = points;
		this.theme = theme;
	}

	public Question(Integer idQuestion, String enonce, String media, Long points, Theme theme, List<Proposition> listePropositions) {
		
		this.idQuestion = idQuestion;
		this.enonce = enonce;
		this.media = media;
		this.points = points;
		this.theme = theme;
		this.listePropositions = listePropositions;
	}

	public Integer getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(Integer idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getEnonce() {
		return enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<Proposition> getListePropositions() {
		return listePropositions;
	}

	public void setListePropositions(List<Proposition> listePropositions) {
		this.listePropositions = listePropositions;
	}

	public void addProposition(Proposition proposition){
		this.listePropositions.add(proposition);
	}

	@Override
	public String toString() {
		return String.format("Question [idQuestion=%s, enonce=%s, media=%s, points=%s, theme=%s, listePropositions=%s]",
				idQuestion, enonce, media, points, theme,"\n"+ listePropositions+"\n");
	}
	

}
