package fr.eni.amel.bo;

public class SectionTest {
	private int idSection;
	private int nbQuestionsATirer;
	
	private Theme theme;
	
	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	// getter et setter
	public int getNbQuestionsATirer() {
		return nbQuestionsATirer;
	}

	public void setNbQuestionsATirer(int nbQuestionsATirer) {
		this.nbQuestionsATirer = nbQuestionsATirer;
	}
	
	public int getIdSection() {
		return idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}

	//constructeur
	
	public SectionTest() {
	}
	
	/**
	 * @param nbQuestionsATirer
	 */
	public SectionTest(int nbQuestionsATirer) {
		super();
		setNbQuestionsATirer(nbQuestionsATirer);
	}

	/**
	 * @param idSection
	 * @param nbQuestionsATirer
	 */
	public SectionTest(int idSection, int nbQuestionsATirer) {
		super();
		this.idSection = idSection;
		this.nbQuestionsATirer = nbQuestionsATirer;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SectionTest [nbQuestionsATirer=");
		builder.append(nbQuestionsATirer);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	

}
