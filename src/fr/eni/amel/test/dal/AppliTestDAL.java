package fr.eni.amel.test.dal;

import java.util.List;

import fr.eni.amel.bo.SectionTest;
import fr.eni.amel.bo.Test;
import fr.eni.amel.dal.SectionTestDao;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.amel.dal.impl.SectionTestDaoImpl;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliTestDAL {
	public static void main(String[] args) throws DaoException {
		// declaration et instanciation de la DAO

		TestDao testDAO = DaoFactory.getTestDao();

		// Creer un nouveau test
		Test test1 = new Test("zezrz", "test sur l'anglais", 60, 80, 20);
		Test test2 = new Test("math", "test sur la langue francaise", 60, 80, 20);

		// insertion des tests
		System.out.println("insertion de test");
		testDAO.insert(test1);
		testDAO.insert(test2);
		System.out.println(test1);
		System.out.println(test2);

		// selection de tous les tests
		List<Test> allTest = testDAO.selectAll();

		System.out.println("---------------------------------------------------------------");
		System.out.println("Selection de tous les tests : ");
		StringBuffer sb = new StringBuffer();
		for (Test test : allTest) {
			sb.append("Test [id = ");
			sb.append(test.getIdTest());
			sb.append(", libelle = ");
			sb.append(test.getLibelle());
			sb.append("description = ");
			sb.append(test.getDescription()).append("]\n");
		}
		System.out.println(sb.toString());
		System.out.println("---------------------------------------------------------------");

		SectionTestDao sectionTestDao = DaoFactory.getSectionTestDao();
		List<SectionTest> listeSectionTests = sectionTestDao.selectByTest(1);

		System.out.println("---------------------------------------------------------------");
		System.out.println("Selection de tous les sections de test : ");
		StringBuffer sb1 = new StringBuffer();
		for (SectionTest sectionTest : listeSectionTests) {
			sb1.append(", nombre de question a tirer = ");
			sb1.append(sectionTest.getNbQuestionsATirer()).append("]\n");
		}
		System.out.println(sb1.toString());
		System.out.println("---------------------------------------------------------------");

		// suppression d'un test
		System.out.println("Suppression de l'article : " + test1.toString());
		testDAO.delete(test1.getIdTest());

		allTest = testDAO.selectAll();
		System.out.println("---------------------------------------------------------------");
		System.out.println("Liste des tests après suppression : ");
		StringBuffer sb11 = new StringBuffer();
		for (Test test : allTest) {
			sb11.append("Test [id = ");
			sb11.append(test.getIdTest());
			sb11.append(", libelle = ");
			sb11.append(test.getLibelle());
			sb11.append("description = ");
			sb11.append(test.getDescription()).append("]\n");
		}
		System.out.println(sb11.toString());
		System.out.println("---------------------------------------------------------------");

		// mise a jour d'un test
		System.out.println("mise a jour d'un test");
		System.out.println("Avant modification :" + test2);
		test2.setLibelle("html et css");
		test2.setDuree(500);
		System.out.println("Apres modification : " + test2);
		testDAO.update(test2);
		System.out.println("mise a jour réussie");

	}
}
