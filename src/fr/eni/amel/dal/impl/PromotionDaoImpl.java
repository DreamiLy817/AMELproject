package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.dal.PromotionDao;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.util.ResourceUtil;

public class PromotionDaoImpl implements PromotionDao{

	private static final String SELECT_PROMO_QUERY = "SELECT p.codePromo, p.libelle FROM PROMOTION p WHERE p.codePromo = ?";
	private static final String SELECT_ALL_PROMO = "SELECT p.codePromo, p.libelle FROM PROMOTION p";
	
	private Connection connection;
	private static PromotionDaoImpl instance;

	public static PromotionDaoImpl getInstance() {
		if (instance == null) {
			instance = new PromotionDaoImpl();
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
	public Promotion insert(Promotion element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Promotion element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Promotion selectById(Integer id) throws DaoException {

		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Promotion promo = null;
		
		try {
			
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_PROMO_QUERY);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				promo = new Promotion();
				promo.setCodePromo(id);
				promo.setLibelle(rs.getString("libelle"));
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
		
		return promo;
	}

	@Override
	public List<Promotion> selectAll() throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Promotion> listePromos = new ArrayList<Promotion>();
		Promotion promo = null;
		
		try {
//			cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_ALL_PROMO);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				promo = new Promotion();
				promo.setCodePromo(rs.getInt("codePromo"));
				promo.setLibelle(rs.getString("libelle"));
				
				listePromos.add(promo);
				
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
		
		return listePromos;
	}

}
