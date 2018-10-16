package fr.eni.amel.bll.manager;



import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.SectionTest;

public interface EpreuveManager {
	

	List<Epreuve> listerEpreuvesPourUtilisateur(Integer idUtilisateur);
	
	List<SectionTest> listerSectionsTestsPourEpreuve(Integer idEpreuve);
	
	List<Question> tirerAuSortQuestions(Integer idEpreuve);
	
	Epreuve getUneEpreuve(Integer idEpreuve);

}
