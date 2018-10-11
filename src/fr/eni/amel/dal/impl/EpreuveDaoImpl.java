package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.bo.Test;
import fr.eni.amel.bo.Utilisateur;
import fr.eni.amel.dal.EpreuveDAO;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class EpreuveDaoImpl implements EpreuveDAO{

	private static final String select_all = "SELECT * FROM EPREUVE";
	private static final String select_id 	= "SELECT * FROM EPREUVE WHERE idEpreuve = ?";
	private static final String select_utilisateur 	= "SELECT * FROM EPREUVE WHERE idUtilisateur = ?";
	private static final String update_id 	= "UPDATE EPREUVE SET dateDedutValidite = ?, dateFinValidite = ?, tempsEcoule = ?, etat = ?, note_obtenue = ? WHERE idEpreuve = ?";
	private static final String insert 	= "INSERT INTO EPREUVE (dateDedutValidite, dateFinValidite, tempsEcoule, etat, note_obtenue, niveau_obtenu, idTest, idUtilisateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	private Connection connection;
	private static EpreuveDaoImpl instance;

	public static EpreuveDaoImpl getInstance() {
		if (instance == null) {
			instance = new EpreuveDaoImpl();
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
	public Epreuve insert(Epreuve element) throws DaoException {
		
		Connection cnx=null;
		PreparedStatement rqt=null;
		Epreuve epreuve = (Epreuve)element;
		
		try{
			cnx = getConnection();
			rqt=cnx.prepareStatement(insert);
			rqt.setDate(1, new java.sql.Date(epreuve.getDateDebutValidite().getTime()));
			rqt.setDate(2, new java.sql.Date(epreuve.getDateFinValidite().getTime()));
			rqt.setInt(3, epreuve.getTempsEcoule());
			rqt.setString(4, epreuve.getEtat());
			rqt.setFloat(5, epreuve.getNote_obtenue());
			rqt.setString(6, epreuve.getNiveau_obtenu());
			rqt.setInt(7, epreuve.getTest().getIdTest());
			rqt.setInt(8, epreuve.getUtilisateur().getIdUtilisateur());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return epreuve;
	}
	
	@Override
	public void update(Epreuve element) throws DaoException {
		
		Epreuve epreuve = (Epreuve)element;
		Connection cnx=null;
		PreparedStatement rqt=null;
		
		try{
			cnx = getConnection();
			rqt=cnx.prepareStatement(update_id);
			rqt.setDate(1, new java.sql.Date(epreuve.getDateDebutValidite().getTime()));
			rqt.setDate(2, new java.sql.Date(epreuve.getDateFinValidite().getTime()));
			rqt.setInt(3, epreuve.getTempsEcoule());
			rqt.setString(4, epreuve.getEtat());
			rqt.setFloat(5, epreuve.getNote_obtenue());
			rqt.setFloat(6, epreuve.getIdEpreuve());

			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Epreuve selectById(Integer id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Epreuve epreuve = null;
		try{	
			cnx = getConnection();
			rqt = cnx.prepareStatement(select_id);
			rqt.setInt(1, (int)id);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations de l'animateur utilis� pour la recherche.
			if (rs.next()){
				epreuve = new Epreuve();
				epreuve.setIdEpreuve(rs.getInt("idEpreuve"));
				epreuve.setDateDebutValidite(rs.getDate("dateDedutValidite"));
				epreuve.setDateFinValidite(rs.getDate("dateFinValidite"));
				epreuve.setTempsEcoule(rs.getInt("tempsEcoule"));
				epreuve.setEtat(rs.getString("etat"));
				epreuve.setNote_obtenue(rs.getInt("note_obtenue"));
				epreuve.setNiveau_obtenu(rs.getString("niveau_obtenu"));
				
				//Ajouter user
				UtilisateurDaoImpl utilisateurDao = UtilisateurDaoImpl.getInstance();
				Utilisateur utilisateur = utilisateurDao.selectById(rs.getInt("idUtilisateur"));
				epreuve.setUtilisateur(utilisateur);
				
				//Ajouter test
				TestDaoImpl TestDao = TestDaoImpl.getInstance();
				Test test = TestDao.selectById(rs.getInt("idTest"));
				epreuve.setTest(test);
				
				//Ajouter Questions Tirages
				QuestionTirageDaoImpl questionDao = QuestionTirageDaoImpl.getInstance();
				List<QuestionTirage> question_tirages = (List)questionDao.selectByIdEpreuve(id);
				epreuve.setlisteQuestionTirage(question_tirages);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		
		return epreuve;
	}
	
	

	public List<Epreuve> selectByUtilisateur(Object id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Epreuve> epreuves = new ArrayList();
		try{	
			cnx = getConnection();
			rqt = cnx.prepareStatement(select_utilisateur);
			rqt.setInt(1, (int)id);
			rs=rqt.executeQuery();
			// SI on trouve au moins 1 résultat, on prend le 1er pour mettre à jour les informations de l'animateur utilis� pour la recherche.
			while (rs.next()){
				
				Epreuve epreuve = new Epreuve();
				epreuve.setIdEpreuve(rs.getInt("idEpreuve"));
				epreuve.setDateDebutValidite(rs.getDate("dateDedutValidite"));
				epreuve.setDateFinValidite(rs.getDate("dateFinValidite"));
				epreuve.setTempsEcoule(rs.getInt("tempsEcoule"));
				epreuve.setEtat(rs.getString("etat"));
				epreuve.setNote_obtenue(rs.getInt("note_obtenue"));
				epreuve.setNiveau_obtenu(rs.getString("niveau_obtenu"));
				
				//Ajouter user
				UtilisateurDaoImpl utilisateurDao = UtilisateurDaoImpl.getInstance();
				Utilisateur utilisateur = utilisateurDao.selectById(rs.getInt("idUtilisateur"));
				epreuve.setUtilisateur(utilisateur);
				
				//Ajouter test
				TestDaoImpl TestDao = TestDaoImpl.getInstance();
				Test test = TestDao.selectById(rs.getInt("idTest"));
				epreuve.setTest(test);
				
				//Ajouter Questions Tirages
				QuestionTirageDaoImpl questionDao = QuestionTirageDaoImpl.getInstance();
				List<QuestionTirage> question_tirages = (List)questionDao.selectByIdEpreuve(id);
				epreuve.setlisteQuestionTirage(question_tirages);
				
				epreuves.add(epreuve);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		
		return epreuves;
	}
	
	
	@Override
	public List<Epreuve> selectAll() throws DaoException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Epreuve> epreuves = new ArrayList<Epreuve>();
		Epreuve epreuve = null;
		try{
			cnx = getConnection();
			rqt = cnx.prepareStatement(select_all);
			rs=rqt.executeQuery();
			
			
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations de l'animateur utilis� pour la recherche.
			while(rs.next()){
				epreuve = new Epreuve();
				epreuve.setIdEpreuve(rs.getInt("idEpreuve"));
				epreuve.setDateDebutValidite(rs.getDate("dateDedutValidite"));
				epreuve.setDateFinValidite(rs.getDate("dateFinValidite"));
				epreuve.setTempsEcoule(rs.getInt("tempsEcoule"));
				epreuve.setEtat(rs.getString("etat"));
				epreuve.setNote_obtenue(rs.getInt("note_obtenue"));
				epreuve.setNiveau_obtenu(rs.getString("niveau_obtenu"));
				
				//Ajouter user
				UtilisateurDaoImpl utilisateurDao = UtilisateurDaoImpl.getInstance();
				Utilisateur utilisateur = utilisateurDao.selectById(rs.getInt("idUtilisateur"));
				epreuve.setUtilisateur(utilisateur);
				
				//Ajouter test
				TestDaoImpl TestDao = TestDaoImpl.getInstance();
				Test test = TestDao.selectById(rs.getInt("idTest"));
				epreuve.setTest(test);
				
				epreuves.add(epreuve);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}finally
		{
			ResourceUtil.safeClose(rs, rqt, cnx);
			connection = null;
		}
		return epreuves;
	} 	
}
