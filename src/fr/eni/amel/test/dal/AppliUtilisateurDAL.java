package fr.eni.amel.test.dal;

import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliUtilisateurDAL {

	public static void main(String[] args) {
		
		// test Sélectionner un-e utilisateurice
//		try {
//			Utilisateur util = DaoFactory.getUtilisateurDao().selectById(4);
//			
//			System.out.println(util);
//		} catch (DaoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		System.out.println("**************************************************************************************************************");
		
		// test ajouter un-e utilisateurice
//		try {
//			
//			Profil marionProfil = DaoFactory.getProfilDao().selectById(4);
//			Promotion marionPromo = DaoFactory.getPromotionDao().selectById(1);
//			
//			Utilisateur util = new Utilisateur(6, "Vasseur", "Marion", "m.vasseur@mail.com", "test05", marionProfil, marionPromo);
//			
//			Utilisateur afficheUtilisateur = DaoFactory.getUtilisateurDao().insert(util);
//			
//			System.out.println(util);
//			System.out.println(afficheUtilisateur.getPrenom() + " " + afficheUtilisateur.getNom() + " est enregistré-e !");
//			
//		} catch (DaoException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
//		System.out.println("**************************************************************************************************************");
		
		// test modifier un-e utilisateurice
		try {
			
			Utilisateur marion = DaoFactory.getUtilisateurDao().selectById(8);
			System.out.println("Compte Marion avant modification :");
			System.out.println(marion.getPrenom() + " " + marion.getNom() + " : mail = "+ marion.getEmail() + ", mot de passe = "+ marion.getPassword());
			System.out.println("profil : " + marion.getProfil().getLibelle() + " et promo : " + marion.getPromo().getLibelle());
			
			marion.setNom("De Oliveira");
			marion.setPrenom("Bruno");
			marion.setEmail("b.deoliveira@mail.com");
			marion.setPassword("test06");
			
			Profil marionProfil = DaoFactory.getProfilDao().selectById(3);
			marion.setProfil(marionProfil);
			
			Promotion marionPromo = DaoFactory.getPromotionDao().selectById(1);
			marion.setPromo(marionPromo);
			
			DaoFactory.getUtilisateurDao().update(marion);
			
			System.out.println("Compte Marion après modification :");
			System.out.println(marion.getPrenom() + " " + marion.getNom() + " : mail = "+ marion.getEmail() + ", mot de passe = "+ marion.getPassword());
			System.out.println("profil : " + marion.getProfil().getLibelle() + " et promo : " + marion.getPromo().getLibelle());
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
//		System.out.println("**************************************************************************************************************");
//		
//		// test supprimer un-e utilisateurice
//		try {
//			
//			Utilisateur marion = DaoFactory.getUtilisateurDao().selectById(9);
//			System.out.println("Compte Marion avant modification :");
//			System.out.println(marion.getPrenom() + " " + marion.getNom() + " : mail = "+ marion.getEmail() + ", mot de passe = "+ marion.getPassword());
//			System.out.println("profil : " + marion.getProfil().getLibelle() + " et promo : " + marion.getPromo().getCodePromo());
//			
//			DaoFactory.getUtilisateurDao().delete(marion.getIdUtilisateur());
//			
//			
//		} catch (DaoException e) {
//			e.printStackTrace();
//		}
//		
		System.out.println("**************************************************************************************************************");
		
		// test Sélectionner toustes les utilisateurices
		try {
			List<Utilisateur> listeUtilisateurs = DaoFactory.getUtilisateurDao().selectAll();
			
			for (Utilisateur utilisateur : listeUtilisateurs) {
				System.out.println(utilisateur);
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
