package fr.eni.amel.bll.manager;



import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.SectionTest;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface EpreuveManager {
	

	List<Epreuve> listerEpreuvesPourUtilisateur(Integer idUtilisateur) throws ManagerException;
	
	List<SectionTest> listerSectionsTestsPourEpreuve(Integer idEpreuve)throws ManagerException;
	
	List<Question> tirerAuSortQuestions(Integer idEpreuve)throws ManagerException;

}
