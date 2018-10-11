package fr.eni.amel.bo;


import java.util.List;

import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Utilisateur;

import java.util.ArrayList;
import java.util.Date;

public class Epreuve {

	private Integer idEpreuve;
	private Date dateDebutValidite;
	private Date dateFinValidite;
	private Integer tempsEcoule;
	private String etat;
	private float note_obtenue;
	private String niveau_obtenu;
	private Test test;
	private Utilisateur utilisateur;
	private ArrayList<QuestionTirage> listeQuestionTirage;
	private Proposition proposition;
	
	
	//Constructeurs
	
	public Epreuve(){
		this.listeQuestionTirage = new ArrayList<QuestionTirage>();
	}
	
	public Epreuve(int idEpreuve, Date dateDebutValidite, Date dateFinValidite, int tempsEcoule, String etat,
			float note_obtenu, Test test, Utilisateur utilisateur, String niveau_obtenu) {
		this.idEpreuve = idEpreuve;
		this.dateDebutValidite = dateDebutValidite;
		this.dateFinValidite = dateFinValidite;
		this.tempsEcoule = tempsEcoule;
		this.etat = etat;
		this.note_obtenue = note_obtenu;
		this.niveau_obtenu = niveau_obtenu;
		this.test = test;
		this.utilisateur = utilisateur;
		this.listeQuestionTirage = new ArrayList<QuestionTirage>();
	}
	
	//Getter

	public Integer getIdEpreuve() {
		return idEpreuve;
	}


	public Date getDateDebutValidite() {
		return dateDebutValidite;
	}


	public Date getDateFinValidite() {
		return dateFinValidite;
	}


	public Integer getTempsEcoule() {
		return tempsEcoule;
	}


	public String getEtat() {
		return etat;
	}

	public Test getTest() {
		return test;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public float getNote_obtenue() {
		return note_obtenue;
	}

	public String getNiveau_obtenu() {
		return niveau_obtenu;
	}
	
	public Proposition getProposition() {
		return this.proposition;
	}

	
	//Setter
	
	
	public void setIdEpreuve(Integer idEpreuve) {
		this.idEpreuve = idEpreuve;
	}

	public void setDateDebutValidite(Date dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public void setTempsEcoule(Integer tempsEcoule) {
		this.tempsEcoule = tempsEcoule;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public void setTest(Test test) {
		this.test = test;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setNote_obtenue(float note_obtenue) {
		this.note_obtenue = note_obtenue;
	}

	public void setNiveau_obtenu(String niveau_obenu) {
		this.niveau_obtenu = niveau_obenu;
	}
	
	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}
	
	//array List
	
	public ArrayList getlisteQuestionTirage()
	{
		return this.listeQuestionTirage;
	}
	
	public void setlisteQuestionTirage(List list)
	{
		this.listeQuestionTirage = (ArrayList<QuestionTirage>)list;
	}
	
	public QuestionTirage getUnQuestionTirage(Integer index)
	{
		return this.listeQuestionTirage.get(index);
	}
	
	public void addQuestionTirage(QuestionTirage questiontirage)
	{
		this.listeQuestionTirage.add(questiontirage);
	}

	@Override
	public String toString() {
		return "Epreuve [idEpreuve=" + idEpreuve + ", dateDebutValidite=" + dateDebutValidite + ", dateFinValidite="
				+ dateFinValidite + ", tempsEcoule=" + tempsEcoule + ", etat=" + etat + ", note_obtenue=" + note_obtenue
				+ ", niveau_obtenu=" + niveau_obtenu + ", test=" + test + ", utilisateur=" + utilisateur
				+ ", listeQuestionTirage=" + listeQuestionTirage + ", proposition=" + proposition + "]";
	}
	
	
	
	
	
}
