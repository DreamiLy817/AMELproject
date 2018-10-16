package fr.eni.amel.bll.manager;



import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.SectionTest;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface EpreuveManager {
	

	List<Epreuve> listerEpreuvesPourUtilisateur(Integer idUtilisateur) throws ManagerException;
	
	List<SectionTest> listerSectionsTestsPourEpreuve(Integer idEpreuve)throws ManagerException;
	
<<<<<<< HEAD
	List<Question> tirerAuSortQuestions(Integer idEpreuve);
	
	Epreuve getUneEpreuve(Integer idEpreuve);
=======
	List<Question> tirerAuSortQuestions(Integer idEpreuve)throws ManagerException;
>>>>>>> e6015d09e4c9ef32a880067dac244f792d634120

}
