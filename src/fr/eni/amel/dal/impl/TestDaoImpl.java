 package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.SectionTest;
import fr.eni.amel.bo.Test;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;

//idTest,libelle,description,duree,seuil_haut,seuil_bas
public class TestDaoImpl implements TestDao{
	private static final String INSERT_TEST_QUERY = "INSERT INTO TEST(libelle, description, duree, seuil_haut, seuil_bas) VALUES(?,?,?,?,?)";
	private static final String SELECT_TEST_QUERY = "SELECT idTest, libelle, description, duree, seuil_haut, seuil_bas FROM TEST  WHERE .idTest=?";
	private static final String SELECT_ALL_TEST = "SELECT idTest,libelle, description, duree, seuil_haut, seuil_bas FROM TEST";
	private static final String UPDATE_TEST_QUERY = "UPDATE TEST SET libelle=? , description=?, duree=?, seuil_haut=?, seuil_bas=? WHERE idTest =? ";
	private static final String DELETE_TEST_QUERY = "DELETE FROM TEST WHERE idTest =? ";
	
	private Connection connection;
	private static TestDaoImpl instance;

	public static TestDaoImpl getInstance() {
		if (instance == null) {
			instance = new TestDaoImpl();
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
	public Test insert(Test test) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(INSERT_TEST_QUERY , Statement.RETURN_GENERATED_KEYS);

			String libelle = test.getLibelle();
			String description = test.getDescription();
			Integer duree = test.getDuree();
			Integer seuil_haut = test.getSeuil_haut();
			Integer seuil_bas = test.getSeuil_bas();
			
			rqt.setString(1, libelle);
			rqt.setString(2, description);
			rqt.setInt(3, duree);
			rqt.setInt(4, seuil_haut);
			rqt.setInt(5, seuil_bas);
		

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				// recuperation du tampon
				rs = rqt.getGeneratedKeys();
				// je vais sur le premier enregistrement s'il existe
				if (rs.next()) {
					test.setIdTest(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					connection = null;
				}
				if (rqt != null) {
					rqt.close();
					connection = null;
				}
				if (cnx != null) {
					cnx.close();
					connection = null;
				}
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return test;
	}

	@Override
	public void update(Test test) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(UPDATE_TEST_QUERY);
		
			rqt.setString(1, test.getLibelle());
			rqt.setString(2, test.getDescription());
			rqt.setInt(3, test.getDuree());
			rqt.setInt(4, test.getSeuil_haut());
			rqt.setInt(5, test.getSeuil_bas());
			//a debugger peut etre 
			rqt.setInt(6, test.getIdTest());
	
			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					connection = null;
				}
				if (cnx != null) {
					cnx.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void delete(Integer id) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(DELETE_TEST_QUERY);
			rqt.setInt(1, id);
			rqt.executeUpdate();
		} catch (SQLException e) {
			// TO DO DALException
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					connection = null;
				}
				if (cnx != null) {
					cnx.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Test selectById(Integer id) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Test test = null;
		
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(SELECT_TEST_QUERY);
			rqt.setInt(1, id);

			rs = rqt.executeQuery();

			if (rs.next()) {
				test = new Test();
				test.setIdTest(id);
				test.setLibelle(rs.getString("libelle"));
				test.setDescription(rs.getString("description"));
				test.setSeuil_haut(rs.getInt("seuil_haut"));
				test.setSeuil_bas(rs.getInt("seuil_bas"));
				test.setDuree(rs.getInt("duree"));
				
				//Ajouter sectionTest
				SectionTestDaoImpl sectionTestDao = SectionTestDaoImpl.getInstance();
				List<SectionTest> listeSectionTest = (List<SectionTest>) sectionTestDao.selectByTest(id);
				test.setListeSectionTests(listeSectionTest);
	
			}

		}  catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
					connection = null;
				}
				if (rqt != null) {
					rqt.close();
					connection = null;
				}
				if (cnx != null) {
					cnx.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return test;
	}

	@Override
	public List<Test> selectAll() throws DaoException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null; 
		List<Test> listeTest = new ArrayList<Test>();
		
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SELECT_ALL_TEST);
			Test test = null; 
			
			while(rs.next()) {
				test = new Test(rs.getInt("idTest"),
						rs.getString("libelle"),
						rs.getString("description"),
						rs.getInt("duree"),
						rs.getInt("seuil_haut"),
						rs.getInt("seuil_bas"));
				
				//Ajouter sectionTest
				SectionTestDaoImpl sectionTestDao = SectionTestDaoImpl.getInstance();
				List<SectionTest> listeSectionTest = (List<SectionTest>) sectionTestDao.selectByTest(test.getIdTest());
				test.setListeSectionTests(listeSectionTest);
				
				listeTest.add(test);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null){
					rs.close();
					connection = null;
				}
				if (rqt != null){
					rqt.close();
					connection = null;
				}
				if(cnx!=null){
					cnx.close();
					connection = null;
				}
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e);
			}
		}
		return listeTest;
	}

}
