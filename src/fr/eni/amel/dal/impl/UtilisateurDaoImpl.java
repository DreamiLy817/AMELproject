package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class UtilisateurDaoImpl implements UtilisateurDao{

	
	private static final String INSERT_UTIL_QUERY = "INSERT INTO UTILISATEUR(nom, prenom, email, password, codeProfil, codePromo) VALUES(?,?,?,?,?,?)";
	private static final String SELECT_UTIL_QUERY = "SELECT u.idUtilisateur, u.nom, u.prenom, u.email, u.password, u.codeProfil, u.codePromo  FROM UTILISATEUR u WHERE u.idUtilisateur = ?";
	private static final String SELECT_ALL_UTILS = "SELECT u.idUtilisateur, u.nom, u.prenom, u.email, u.password, u.codeProfil, u.codePromo  FROM UTILISATEUR u";
	private static final String UPDATE_UTIL_QUERY = "UPDATE UTILISATEUR SET (nom=?, prenom=?, email=?, password=?, codeProfil=?; codePromo=?) WHERE iUtilisateur = ?";
	private static final String DELETE_UTIL_QUERY = "DELETE FROM UTILISATEUR WHERE idUtilisateur = ?";
	
	private static UtilisateurDaoImpl instance;
	
	public static UtilisateurDaoImpl getInstance() {
		if (instance == null) {
			instance = new UtilisateurDaoImpl();
		}
		return instance;
	}
	
	@Override
	public Utilisateur insert(Utilisateur utilisateur) throws DaoException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			cnx = MSSQLConnectionFactory.get();
			stmt = cnx.prepareStatement(INSERT_UTIL_QUERY, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, utilisateur.getNom());
			stmt.setString(2, utilisateur.getPrenom());
			stmt.setString(3, utilisateur.getEmail());
			stmt.setString(4, utilisateur.getPassword());
			stmt.setInt(5, utilisateur.getProfil().getCodeProfil());
			stmt.setInt(6, utilisateur.getPromo().getCodePromo());
			
			if (stmt.executeUpdate() == 1) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setIdUtilisateur(rs.getInt(1));
				}
			}
			
		} catch(SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(rs, stmt, cnx);
		}
		
		return utilisateur;
	}

	@Override
	public void update(Utilisateur utilisateur) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			cnx = MSSQLConnectionFactory.get();
			stmt = cnx.prepareStatement(UPDATE_UTIL_QUERY);
			stmt.setString(1,utilisateur.getNom());
			stmt.setString(2, utilisateur.getPrenom());
			stmt.setString(3, utilisateur.getEmail());
			stmt.setString(4, utilisateur.getPassword());
			stmt.setInt(5, utilisateur.getProfil().getCodeProfil());
			stmt.setInt(6, utilisateur.getPromo().getCodePromo());
			
			
		} catch(SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(rs, stmt, cnx);
		}
	}

	@Override
	public void delete(Integer idUtilisateur) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		
		try {
			cnx = MSSQLConnectionFactory.get();
			stmt = cnx.prepareStatement(DELETE_UTIL_QUERY);
			stmt.setInt(1, idUtilisateur);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(stmt, cnx);
		}

		
	}

	@Override
	public Utilisateur selectById(Integer id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;
		
		try {
			
			cnx = MSSQLConnectionFactory.get();
			stmt = cnx.prepareStatement(SELECT_UTIL_QUERY);
			
			
		} catch(SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}finally {
			ResourceUtil.safeClose(rs, stmt, cnx);
		}
		
		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectAll() throws DaoException {

		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Utilisateur> listeUtilisateurs = null;
		
		return listeUtilisateurs;
	}

}
