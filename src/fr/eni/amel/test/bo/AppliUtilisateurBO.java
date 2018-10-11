package fr.eni.amel.test.bo;

import java.util.Date;
import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.amel.dal.impl.EpreuveDaoImpl;
import fr.eni.amel.dal.impl.UtilisateurDaoImpl;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliUtilisateurBO {

		public static void main(String[] args) {
			
					// Creer une nouvelle utilisatrice 
					Profil unProfil = new Profil(3, "interne");
					Promotion unePromo = new Promotion(1, "CDI-00");
					Utilisateur unUtil = new Utilisateur(5, "Vasseur","Marion", "m.vasseur@mail.com", "mv", unProfil, unePromo);
					System.out.println(unUtil.toString());
					
					UtilisateurDaoImpl utilisateurDao = UtilisateurDaoImpl.getInstance();
					
					try {
						List<Utilisateur> listeUtilisateurs = utilisateurDao.selectAll();
						System.out.println("Liste des utilisateurices : ");
						
						for (Utilisateur utilisateur : listeUtilisateurs) {
							System.out.println(utilisateur);
						}
						
					} catch(DaoException e) {
						e.printStackTrace();
					}
					
				
		}
}
