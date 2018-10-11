package fr.eni.amel.bo;

import java.util.List;

public class Promotion {

	private int codePromo;
	private String libelle;
	private List<Utilisateur> listeUtilisateurs;
	
	private Promotion() {
	}

	public Promotion(int codePromo, String libelle) {
		super();
		setCodePromo(codePromo);
		setLibelle(libelle);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Promotion [codePromo=" + codePromo + ", libelle=" + libelle
				+ "]";
	}
	
	
}
