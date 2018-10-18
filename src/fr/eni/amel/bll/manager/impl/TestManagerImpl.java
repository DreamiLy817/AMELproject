package fr.eni.amel.bll.manager.impl;

import java.util.List;

import fr.eni.amel.bll.manager.TestManager;
import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class TestManagerImpl implements TestManager {
	
	private static TestManagerImpl instance;
	private TestDao testDAO = DaoFactory.getTestDao();
	
	
	public static TestManagerImpl getInstance()
	{
		if (instance == null) {
			instance = new TestManagerImpl();
		}
		return instance;
	}

	/**
	 * Afficher la liste de Test
	 */
	@Override
	public List<Test> getListeOfTest() {
		List<Test> listeTest = null;
		
		try {
			listeTest = testDAO.selectAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeTest;
		
		
	}

}
