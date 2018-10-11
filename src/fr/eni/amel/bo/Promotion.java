package fr.eni.amel.bo;

import java.util.ArrayList;
import java.util.List;

public class Promotion {

	private int codePromo;
	private String libelle;
	private List<Utilisateur> listeUtilisateurs;
	
	public Promotion() {
	}

	public Promotion(int codePromo, String libelle) {
		super();
		setCodePromo(codePromo);
		setLibelle(libelle);
		this.listeUtilisateurs = new ArrayList<Utilisateur>();
	}
	
	/**
	 * @return the codePromo
	 */
	public int getCodePromo() {
		return codePromo;
	}

	/**
	 * @param codePromo the codePromo to set
	 */
	public void setCodePromo(int codePromo) {
		this.codePromo = codePromo;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	//les arrayList
	
	/**
	 * 
	 * @return une liste d'Utilisateurs
	 */
	public ArrayList<Utilisateur> getlisteUtilisateurs()
	{
		return (ArrayList<Utilisateur>) this.listeUtilisateurs;
	}
	
	/**
	 * 
	 * @param list utilisateurs to set
	 */
	public void setlisteUtilisateurs(List<Utilisateur> list)
	{
		this.listeUtilisateurs = (ArrayList<Utilisateur>)list;
	}
	
	/**
	 * 
	 * @param index
	 * @return un utilisateur parmi la liste des utilisateurs
	 */
	public Utilisateur getUnUtilisateur(int index)
	{
		return this.listeUtilisateurs.get(index);
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Promotion [codePromo=" + codePromo + ", libelle=" + libelle
				+ "]";
	}
	
	
}
