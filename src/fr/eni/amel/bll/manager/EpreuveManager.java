package fr.eni.amel.bll.manager;

import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.SectionTest;

public interface EpreuveManager {
	

	List<Epreuve> listerEpreuvesPourUtilisateur(Integer idUtilisateur);
	
	List<SectionTest> listerSectionsTestsPourEpreuve(Integer idEpreuve);
	
}
