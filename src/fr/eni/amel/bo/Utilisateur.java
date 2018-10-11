package fr.eni.amel.bo;

public class Utilisateur {
	
	private int idUtilisateur;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private Profil profil;
	private Promotion promo;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(int idUtilisateur, String nom, String prenom, String email, String password, Profil profil, Promotion promotion) {
		super();
		setIdUtilisateur(idUtilisateur);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setPassword(password);
		setProfil(profil);
		setPromo(promotion);
	}

	/**
	 * @return the idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return the password
	 */
	public Profil getProfil() {
		return profil;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	/**
	 * @return the password
	 */
	public Promotion getPromo() {
		return promo;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPromo(Promotion promo) {
		this.promo = promo;
	}

	/** 
	 * Méthode toString de Utilisateur
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
	
	
}
