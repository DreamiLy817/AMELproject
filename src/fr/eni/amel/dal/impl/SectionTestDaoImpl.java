package fr.eni.amel.dal.impl;

import java.util.List;

import fr.eni.amel.bo.SectionTest;
import fr.eni.amel.dal.SectionTestDao;
import fr.eni.tp.web.common.dal.exception.DaoException;



public class SectionTestDaoImpl implements SectionTestDao {
	
	private static SectionTestDaoImpl instance;
	
	public static SectionTestDaoImpl getInstance() {
		if( instance == null) {
			instance = new SectionTestDaoImpl();
		}
		return instance;
	}

	@Override
	public SectionTest insert(SectionTest sectionT) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SectionTest sectionT) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SectionTest selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SectionTest> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
