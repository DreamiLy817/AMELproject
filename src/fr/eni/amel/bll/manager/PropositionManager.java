package fr.eni.amel.bll.manager;

public interface PropositionManager {

	public void Repondre(QuestionTirage questiontirage, List<Proposition> newlisteproposition);
	public List<Proposition> getReponseCochee(Integer idEpreuve,Integer idQuestion);
}
