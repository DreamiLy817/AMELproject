package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.util.ResourceUtil;

public class UtilisateurDaoImpl implements UtilisateurDao{

	
	private static final String INSERT_UTIL_QUERY = "INSERT INTO UTILISATEUR(nom, prenom, email, password, codeProfil, codePromo) VALUES(?,?,?,?,?,?)";
	private static final String SELECT_UTIL_QUERY = "SELECT u.idUtilisateur, u.nom, u.prenom, u.email, u.password, u.codeProfil, u.codePromo  FROM UTILISATEUR u WHERE u.idUtilisateur = ?";
	private static final String SELECT_ALL_UTILS = "SELECT u.idUtilisateur, u.nom, u.prenom, u.email, u.password, u.codeProfil, u.codePromo  FROM UTILISATEUR u";
	private static final String UPDATE_UTIL_QUERY = "UPDATE UTILISATEUR SET nom=?, prenom=?, email=?, password=?, codeProfil=?, codePromo=? WHERE idUtilisateur = ?";
	private static final String DELETE_UTIL_QUERY = "DELETE FROM UTILISATEUR WHERE idUtilisateur = ?";
	private static final String SELECT_UTIL_BY_EMAIL_PASSWORD = "SELECT u.idUtilisateur, u.nom, u.prenom, u.email, u.password, u.codeProfil, u.codePromo FROM UTILISATEUR u WHERE u.email = ? and u.password = ?";
	private static final String RECHERCHE_UTIL_QUERY = "SELECT  * FROM UTILISATEUR WHERE  codeProfil = 3 AND (nom LIKE ? OR prenom LIKE ?) ORDER BY idUtilisateur ASC";
	private static final String SELECT_ALL_CANDIDATS = "SELECT  * FROM UTILISATEUR WHERE  codeProfil = 3";
	
	private Connection connection;
	private static UtilisateurDaoImpl instance;
	
	public static UtilisateurDaoImpl getInstance() {
		if (instance == null) {
			instance = new UtilisateurDaoImpl();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		
		if (connection == null) {
			connection = ConnectBDD.jdbcConnexion();
		}
		return connection;
	}
	
	@Override
	public Utilisateur insert(Utilisateur utilisateur) throws DaoException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
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
		
		return utilisateur;
	}

	@Override
	public void update(Utilisateur utilisateur) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
//			cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			stmt = cnx.prepareStatement(UPDATE_UTIL_QUERY);
			stmt.setString(1,utilisateur.getNom());
			stmt.setString(2, utilisateur.getPrenom());
			stmt.setString(3, utilisateur.getEmail());
			stmt.setString(4, utilisateur.getPassword());
			stmt.setInt(5, utilisateur.getProfil().getCodeProfil());
			stmt.setInt(6, utilisateur.getPromo().getCodePromo());
			stmt.setInt(7, utilisateur.getIdUtilisateur());
			
			stmt.executeUpdate();
			
		} catch(SQLException e) {
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
	}

	@Override
	public void delete(Integer idUtilisateur) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		
		try {
//			cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			stmt = cnx.prepareStatement(DELETE_UTIL_QUERY);
			stmt.setInt(1, idUtilisateur);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(stmt);
			try {
				if (cnx != null) {	
					cnx.close();
					this.connection = null;
				} 
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e);
				
			}
		}

		
	}

	@Override
	public Utilisateur selectById(Integer id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;
		
		try {
			
//			cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_UTIL_QUERY);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setIdUtilisateur(id);
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setPassword(rs.getString("password"));
				
				ProfilDaoImpl profilDAO =  ProfilDaoImpl.getInstance();
				Profil unProfil = (Profil)profilDAO.selectById(rs.getInt("codeProfil"));
				utilisateur.setProfil(unProfil);
				
				PromotionDaoImpl promoDAO = PromotionDaoImpl.getInstance();
				Promotion unePromo = promoDAO.selectById(rs.getInt("codePromo"));
				utilisateur.setPromo(unePromo);
				
			}
			
		} catch(SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}finally {
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
		
		return utilisateur;
	}

	@Override
	public List<Utilisateur> selectAll() throws DaoException {

		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		Utilisateur utilisateur = null;
		
		try {
//			cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_ALL_UTILS);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setPassword(rs.getString("password"));
				
				ProfilDaoImpl profilDAO =  ProfilDaoImpl.getInstance();
				Profil unProfil = (Profil)profilDAO.selectById(rs.getInt("codeProfil"));
				utilisateur.setProfil(unProfil);
				
				PromotionDaoImpl promoDAO = PromotionDaoImpl.getInstance();
				Promotion unePromo = (Promotion)promoDAO.selectById(rs.getInt("codePromo"));
				utilisateur.setPromo(unePromo);
				
				listeUtilisateurs.add(utilisateur);
				
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
		
		return listeUtilisateurs;
	}
	
	public Utilisateur selectByMailAndPassword(String mail, String password) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Utilisateur utilisateur = null;
		
		try {
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_UTIL_BY_EMAIL_PASSWORD);
			stmt.setString(1, mail);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(mail);
				utilisateur.setPassword(password);
				
				ProfilDaoImpl profilDao = ProfilDaoImpl.getInstance();
				Profil profil = (Profil)profilDao.selectById(rs.getInt("codeProfil"));
				utilisateur.setProfil(profil);
				
				PromotionDaoImpl promoDao = PromotionDaoImpl.getInstance();
				Promotion promo = (Promotion)promoDao.selectById(rs.getInt("codePromo"));
				utilisateur.setPromo(promo);
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
		
		return utilisateur;
		
	}

	@Override
	public List<Utilisateur> rechercherCandidat(String recherche) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null; 
		List<Utilisateur> listeUser = new ArrayList<Utilisateur>();
		Utilisateur user = null;
		try {
			//cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			rqt = cnx.prepareStatement(RECHERCHE_UTIL_QUERY);
			rqt.setString(1, "%" + recherche + "%");
			rqt.setString(2, "%" + recherche + "%");
			rs = rqt.executeQuery();
		
			while(rs.next()) {
				user = new Utilisateur(rs.getInt("idUtilisateur"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getString("email"),
						rs.getString("password"));
				
				ProfilDaoImpl profilDAO =  ProfilDaoImpl.getInstance();
				Profil unProfil = (Profil)profilDAO.selectById(rs.getInt("codeProfil"));
				user.setProfil(unProfil);
				
				PromotionDaoImpl promoDAO = PromotionDaoImpl.getInstance();
				Promotion unePromo = (Promotion)promoDAO.selectById(rs.getInt("codePromo"));
				user.setPromo(unePromo);
			
				listeUser.add(user);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					this.connection = null;
				}
				if (cnx != null) {
					cnx.close();
					this.connection = null;
				}
			} catch (SQLException e) {
				throw new DaoException(e.getMessage(), e);
			}
		}
		return listeUser;
	}

	@Override
	public List<Utilisateur> listeCandidats() throws DaoException {
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
		Utilisateur utilisateur = null;
		
		try {
//			cnx = MSSQLConnectionFactory.get();
			cnx = getConnection();
			stmt = cnx.prepareStatement(SELECT_ALL_CANDIDATS);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setIdUtilisateur(rs.getInt("idUtilisateur"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setPassword(rs.getString("password"));
				
				ProfilDaoImpl profilDAO =  ProfilDaoImpl.getInstance();
				Profil unProfil = (Profil)profilDAO.selectById(rs.getInt("codeProfil"));
				utilisateur.setProfil(unProfil);
				
				PromotionDaoImpl promoDAO = PromotionDaoImpl.getInstance();
				Promotion unePromo = (Promotion)promoDAO.selectById(rs.getInt("codePromo"));
				utilisateur.setPromo(unePromo);
				
				listeUtilisateurs.add(utilisateur);
				
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
		
		return listeUtilisateurs;
	}
	
}
