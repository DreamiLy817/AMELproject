package fr.eni.amel.bo;

import java.util.List;

public class Profil {

	private int codeProfil;
	private String libelle;
	private List<Utilisateur> listeUtilisateurs;
	
	public Profil() {	
	}

	public Profil(int codeProfil, String libelle) {
		super();
		this.codeProfil = codeProfil;
		this.libelle = libelle;
	}


	/**
	 * @return the codeProfil
	 */
	public int getCodeProfil() {
		return codeProfil;
	}

	/**
	 * @param codeProfil the codeProfil to set
	 */
	public void setCodeProfil(int codeProfil) {
		this.codeProfil = codeProfil;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profil [codeProfil=" + codeProfil + ", libelle=" + libelle 
				+ "]";
	}
	
	
}
