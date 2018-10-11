package fr.eni.amel.dal.factory;

import fr.eni.amel.dal.EpreuveDAO;
import fr.eni.amel.dal.ProfilDao;
import fr.eni.amel.dal.PromotionDao;
import fr.eni.amel.dal.PropositionDao;
import fr.eni.amel.dal.QuestionDao;
import fr.eni.amel.dal.QuestionTirageDAO;
import fr.eni.amel.dal.SectionTestDao;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.ThemeDao;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.amel.dal.impl.EpreuveDaoImpl;
import fr.eni.amel.dal.impl.ProfilDaoImpl;
import fr.eni.amel.dal.impl.PromotionDaoImpl;
import fr.eni.amel.dal.impl.PropositionDaoImpl;
import fr.eni.amel.dal.impl.QuestionDaoImpl;
import fr.eni.amel.dal.impl.QuestionTirageDaoImpl;
import fr.eni.amel.dal.impl.SectionTestDaoImpl;
import fr.eni.amel.dal.impl.TestDaoImpl;
import fr.eni.amel.dal.impl.ThemeDaoImpl;
import fr.eni.amel.dal.impl.UtilisateurDaoImpl;

public class DaoFactory {
	
	public static TestDao getTestDao() {
		return TestDaoImpl.getInstance();
	}
	public static ThemeDao getThemeDao() {
		return ThemeDaoImpl.getInstance();
		
	}
	public static SectionTestDao getSectionTestDao() {
		return SectionTestDaoImpl.getInstance();
	}

	public static PropositionDao propositionDAO() {
		return PropositionDaoImpl.getInstance();
	}
	 
 	public static QuestionDao questionDAO() {
		return QuestionDaoImpl.getInstance();
	}
 	
 	public static UtilisateurDao getUtilisateurDao() {
 		return UtilisateurDaoImpl.getInstance();
 	}
 	
 	public static ProfilDao getProfilDao() {
 		return ProfilDaoImpl.getInstance();
 	}
 	
 	public static PromotionDao getPromotionDao() {
 		return PromotionDaoImpl.getInstance();
 	}
 	
 	public static EpreuveDAO epreuveDAO() {
		return EpreuveDaoImpl.getInstance();
	}
 	
 	public static QuestionTirageDAO questiontirageDAO() {
		return QuestionTirageDaoImpl.getInstance();
	}
}
