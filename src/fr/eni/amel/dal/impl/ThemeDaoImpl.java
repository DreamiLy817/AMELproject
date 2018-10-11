package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Theme;
import fr.eni.amel.dal.ThemeDao;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class ThemeDaoImpl  implements ThemeDao{
	
	private static final String INSERT_THEME_QUERY = "INSERT INTO THEME(libelle) VALUES(?)";
	private static final String SELECT_THEME_QUERY = "SELECT idTheme, libelle FROM THEME WHERE idTheme=?";
	private static final String SELECT_ALL_THEME = "SELECT idTheme, libelle FROM THEME";
	private static final String UPDATE_THEME_QUERY = "UPDATE THEME SET (libelle=? ) WHERE idTheme =? ";
	private static final String DELETE_THEME_QUERY = "DELETE FROM TEST WHERE idThest =? ";
	
	private Connection connection;
	private static ThemeDaoImpl instance;

	public static ThemeDaoImpl getInstance() {
		if (instance == null) {
			instance = new ThemeDaoImpl();
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
	public Theme insert(Theme theme) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(INSERT_THEME_QUERY , Statement.RETURN_GENERATED_KEYS);

			String libelle = theme.getLibelle();

			
			rqt.setString(1, libelle);


			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				// recuperation du tampon
				rs = rqt.getGeneratedKeys();
				// je vais sur le premier enregistrement s'il existe
				if (rs.next()) {
					theme.setIdTheme(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theme;
	}

	@Override
	public void update(Theme theme) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(UPDATE_THEME_QUERY);
		
			rqt.setString(1, theme.getLibelle());
			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
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
			rqt = cnx.prepareStatement(DELETE_THEME_QUERY);
			rqt.setInt(1, id);
			rqt.executeUpdate();
		} catch (SQLException e) {
			// TO DO DALException
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public Theme selectById(Integer id) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Theme theme = null;
		
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(SELECT_THEME_QUERY);
			rqt.setInt(1, id);

			rs = rqt.executeQuery();

			if (rs.next()) {
				theme = new Theme();
				theme.setIdTheme(id);
				theme.setLibelle(rs.getString("libelle"));
			}

		}  catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return theme;
	}

	@Override
	public List<Theme> selectAll() throws DaoException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null; 
		List<Theme> listeTheme = new ArrayList<Theme>();
		
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SELECT_ALL_THEME);
			Theme theme = null; 
			
			while(rs.next()) {
				theme = new Theme(rs.getInt("idTest"),
						rs.getString("libelle"));
					
				
				listeTheme.add(theme);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null){
					rs.close();
				}
				if (rqt != null){
					rqt.close();
				}
				if(cnx!=null){
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e);
			}
		}
		return listeTheme;
	}
}
