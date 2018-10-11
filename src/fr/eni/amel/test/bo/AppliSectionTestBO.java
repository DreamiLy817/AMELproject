package fr.eni.amel.test.bo;

import fr.eni.amel.bo.SectionTest;
import fr.eni.amel.bo.Test;
import fr.eni.amel.dal.SectionTestDao;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliSectionTestBO {
	public static void main(String[] args) throws DaoException {
		// declaration et instanciation de la DAO

		SectionTestDao sectionTestDAO = DaoFactory.getSectionTestDao();

		// Creer un nouveau test
		SectionTest sectionT1 = new SectionTest(30);
		
		System.out.println(sectionT1);
	}

}
