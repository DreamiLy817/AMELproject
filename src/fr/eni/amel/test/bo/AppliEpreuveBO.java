package fr.eni.amel.test.bo;

import java.util.Date;
import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.EpreuveDAO;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.amel.dal.impl.EpreuveDaoImpl;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliEpreuveBO {
	
	public static void main(String[] args) {
		// declaration et instanciation de la DAO
		
				TestDao testDAO = DaoFactory.getTestDao();
				
				// Creer un nouveau test 
				Test test1 = new Test("JAVA","test sur le language de programmation JAVA", 60, 80, 20);
				test1.setIdTest(1);
				System.out.println(test1);
				
				Promotion promo = new Promotion(1, "CDI-00");
				System.out.println(promo);
				
				Profil profil = new Profil(3, "interne");
				System.out.println(profil);
				
				Utilisateur utilisateur1 = new Utilisateur(2, "Grapin", "Emmy", "b@b.com", "test05", profil, promo);
				System.out.println(utilisateur1);
				
				Epreuve epreuve = new Epreuve(4, new Date(),  new Date(), 0, "ET", 82F, test1, utilisateur1, "A");
				System.out.println(epreuve);
				
				//TEST DAO
				EpreuveDaoImpl epreuvedao = EpreuveDaoImpl.getInstance();
				
				try {
					List<Epreuve> epreuves = epreuvedao.selectAll();
					
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("Les epreuves : ");
					
					for (Epreuve uneEpreuve: epreuves) {
						System.out.println(uneEpreuve);
					}
					
				} catch (DaoException e) {
					e.printStackTrace();
				}
				
				
				try {
					epreuve = (Epreuve)epreuvedao.selectById(1);
					epreuve.setEtat("TE");
					epreuvedao.update(epreuve);
					
					epreuve = (Epreuve)epreuvedao.selectById(1);
					
					System.out.println(" ");
					System.out.println(" ");
					System.out.println("Nouvelle epreuve : ");				

					System.out.println(epreuve);
					
				} catch (DaoException e) {
					e.printStackTrace();
				}
		}
	
}
