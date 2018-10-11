package fr.eni.amel.dal;

import java.util.List;

import fr.eni.amel.bo.SectionTest;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface SectionTestDao extends GenericDAO<SectionTest, Integer> {
	
	public List<SectionTest> selectByTest(Integer id) throws DaoException; 
	
	public List<SectionTest> selectByTheme(Integer id) throws DaoException;
	
}
