package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.bo.SectionTest;
import fr.eni.amel.bo.Test;
import fr.eni.amel.dal.SectionTestDao;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;



public class SectionTestDaoImpl implements SectionTestDao {
	private static final String SELECT_BY_TEST = "SELECT nbQuestionsATirer, idTest, idTheme  FROM SECTION_TEST WHERE idTest =? ";
	
	private static final String SELECT__BY_THEME = "SELECT nbQuestionsATirer, idTest, idTheme FROM SECTION_TEST WHERE idTheme=?";
	private static final String SELECT_ALL_SECTION_TEST = "SELECT nbQuestionsATirer, idTest, idTheme FROM SECTION_TEST";

	
	private Connection connection;
	private static SectionTestDaoImpl instance;
	
	public static SectionTestDaoImpl getInstance() {
		if( instance == null) {
			instance = new SectionTestDaoImpl();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException 
	{
		//test la connexion si null
		if(connection == null) {
			connection = ConnectBDD.jdbcConnexion();
		}
			return connection;
	}

	@Override
	public SectionTest insert(SectionTest sectionT) throws DaoException {
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

	public List<SectionTest> selectByTest(Integer id) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<SectionTest> listeSectionTest = new ArrayList<SectionTest>();
		SectionTest sectionTest = null;
		try{
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_TEST);
			rqt.setInt(1, (int)id);
			rs=rqt.executeQuery();
			
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations de l'animateur utilis� pour la recherche.
			while(rs.next()){
				sectionTest  = new SectionTest();
				sectionTest.setNbQuestionsATirer(rs.getInt("nbQuestionsATirer"));
			
			
				listeSectionTest.add(sectionTest);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return listeSectionTest;
	} 
	
	public List<SectionTest> selectByTheme(Integer id) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<SectionTest> listeSectionTest = new ArrayList<SectionTest>();
		SectionTest sectionTest = null;
		try{
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(SELECT_BY_TEST);
			rqt.setInt(1, (int)id);
			rs=rqt.executeQuery();
			
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations de l'animateur utilis� pour la recherche.
			while(rs.next()){
				sectionTest  = new SectionTest();
				sectionTest.setNbQuestionsATirer(rs.getInt("nbQuestionsATirer"));
			
			
				listeSectionTest.add(sectionTest);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return listeSectionTest;
	} 
}
