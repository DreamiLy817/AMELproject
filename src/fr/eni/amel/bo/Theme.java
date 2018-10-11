package fr.eni.amel.bo;

import java.util.List;

public class Theme {
	
	private int idTheme; 
	private String libelle;
	private List listeQuestions;
	
	//getter and setter 
	public int getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List getListeQuestions() {
		return listeQuestions;
	}
	public void setListeQuestions(List listeQuestions) {
		this.listeQuestions = listeQuestions;
	}
	
	//constructeur 
	/**
	 * @param idTheme
	 * @param libelle
	 * @param listeQuestions
	 */
	
	public Theme() {
		super();
	}
	
	public Theme(int idTheme, String libelle) {
		super();
		setIdTheme(idTheme);
		setLibelle(libelle);
	}
	public Theme(int idTheme, String libelle, List listeQuestions) {
		super();
		setIdTheme(idTheme);
		setLibelle(libelle);
		setListeQuestions(listeQuestions);
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Theme [idTheme=");
		builder.append(idTheme);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", listeQuestions=");
		builder.append(listeQuestions);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
