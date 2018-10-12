package fr.eni.amel.bll.manager;

import java.util.List;

import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.QuestionTirage;

public interface PropositionManager {
	
	public void Repondre(QuestionTirage questiontirage, List<Proposition> newlisteproposition);

}
