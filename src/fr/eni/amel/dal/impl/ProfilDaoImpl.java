package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.ProfilDao;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.util.ResourceUtil;

public class ProfilDaoImpl implements ProfilDao {

	private static final String SELECT_PROFIL_QUERY = "SELECT p.codeProfil, p.libelle FROM PROFIL p WHERE p.codeProfil = ?";
private static final String SELECT_ALL_PROFIL = "SELECT p.codeProfil, p.libelle FROM PROFIL p";
	
	private Connection connection;
	private static ProfilDaoImpl instance;

	public static ProfilDaoImpl getInstance() {
		if (instance == null) {
			instance = new ProfilDaoImpl();
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
	public Profil insert(Profil element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Profil element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profil selectById(Integer id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Profil profil = null;
		
		try {
			
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_PROFIL_QUERY);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				profil = new Profil();
				profil.setCodeProfil(id);
				profil.setLibelle(rs.getString("libelle"));
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(rs, stmt);
			try {
				if (cnx != null) {	
					cnx.close();
					this.connection = null;
				} 
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e);
				
			}
		}
		
		return profil;
	}

	@Override
	public List<Profil> selectAll() throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Profil> listeProfils = new ArrayList<Profil>();
		Profil profil = null;
		
		try {
//			cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_ALL_PROFIL);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				profil = new Profil();
				profil.setCodeProfil(rs.getInt("codeProfil"));
				profil.setLibelle(rs.getString("libelle"));
				
				listeProfils.add(profil);
				
			}
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(rs, stmt);
			try {
				if (cnx != null) {	
					cnx.close();
					this.connection = null;
				} 
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e);
				
			}
		}
		
		return listeProfils;
	}

	
}
