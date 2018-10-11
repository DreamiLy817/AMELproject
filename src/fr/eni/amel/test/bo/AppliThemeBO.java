package fr.eni.amel.test.bo;


import fr.eni.amel.bo.Theme;
import fr.eni.amel.dal.ThemeDao;
import fr.eni.amel.dal.factory.DaoFactory;

public class AppliThemeBO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThemeDao themeDAO = DaoFactory.getThemeDao();

		// Creer un nouveau test
		Theme theme1 = new Theme("POO");
		Theme theme2 = new Theme("sql");
		
		System.out.println(theme1);
		System.out.println(theme2);

	}

}
