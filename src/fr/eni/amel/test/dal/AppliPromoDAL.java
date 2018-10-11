package fr.eni.amel.test.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliPromoDAL {

	public static void main(String[] args) {


		// test sélection d'une Promo
		try {
			Promotion unePromo = DaoFactory.getPromotionDao().selectById(1);
			
			System.out.println(unePromo.toString());
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// test sélection de toutes les promotions
		System.out.println("Liste des promotions :");
		List<Promotion> listePromos = new ArrayList<Promotion>();
		
		try {
			listePromos = DaoFactory.getPromotionDao().selectAll();
			
			for ( Promotion promo : listePromos) {
				System.out.println(promo);
			}
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
