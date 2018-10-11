package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.dal.QuestionTirageDAO;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class QuestionTirageDaoImpl implements QuestionTirageDAO{
	
private static final String insert 	= "INSERT INTO QUESTION_TIRAGE (estMarquee, idQuestion, numordre, idEpreuve) VALUES (?, ?, ?, ?)";
private static final String insert_reponse 	= "INSERT INTO REPONSE_TIRAGE (idProposition, idQuestion, idEpreuve) VALUES (?, ?, ?)";
private static final String delete_reponse 	= "DELETE FROM REPONSE_TIRAGE WHERE idProposition = ? and  idQuestion = ? and idEpreuve = ?)";
private static final String select_all 	= "SELECT * FROM QUESTION_TIRAGE ";
private static final String select_epreuve 	= "SELECT * FROM QUESTION_TIRAGE WHERE idEpreuve = ?";

private Connection connection;
private static QuestionTirageDaoImpl instance;

public static QuestionTirageDaoImpl getInstance() {
	if (instance == null) {
		instance = new QuestionTirageDaoImpl();
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
	public Object insert(Object element) throws DaoException {
		
		Connection cnx=null;
		PreparedStatement rqt=null;
		QuestionTirage tirage = (QuestionTirage)element;
		
		try{
			cnx = getConnection();
			rqt=cnx.prepareStatement(insert);
			rqt.setBoolean(1, tirage.isEstmarquee());
			rqt.setInt(2,tirage.getQuestion().getIdQuestion());
			rqt.setInt(3, tirage.getNumordre());
			rqt.setInt(4, tirage.getEpreuve().getIdEpreuve());
			rqt.executeUpdate();
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return tirage;
	}

	@Override
	public void update(Object element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object selectById(Object id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll() throws DaoException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<QuestionTirage> question_tirages = new ArrayList<QuestionTirage>();
		QuestionTirage question_tirage = null;
		try{
			cnx = getConnection();
			rqt = cnx.prepareStatement(select_all);
			rs=rqt.executeQuery();
			
			
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations de l'animateur utilis� pour la recherche.
			while(rs.next()){
				question_tirage = new QuestionTirage();
				question_tirage.setEstmarquee(rs.getBoolean("estMarquee"));;
				question_tirage.setNumordre(rs.getInt("numordre"));
				
				//Ajouter epreuve
				EpreuveDaoImpl epreuveDAO = EpreuveDaoImpl.getInstance();
				Epreuve epreuve = (Epreuve)epreuveDAO.selectById(rs.getInt("idEpreuve"));
				question_tirage.setEpreuve(epreuve);
								
				//Ajouter question
				QuestionDaoImpl questionDAO = QuestionDaoImpl.getInstance();
				Question question = (Question)questionDAO.selectById(rs.getInt("idQuestion"));
				question_tirage.setQuestion(question);
				
				
				question_tirages.add(question_tirage);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return question_tirages;
	}
	

	@Override
	public Object selectByIdEpreuve(Object id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<QuestionTirage> question_tirages = new ArrayList<QuestionTirage>();
		QuestionTirage question_tirage = null;
		try{
			cnx = getConnection();
			rqt = cnx.prepareStatement(select_epreuve);
			rqt.setInt(1, (int)id);
			rs=rqt.executeQuery();
			
			
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations de l'animateur utilis� pour la recherche.
			while(rs.next()){
				question_tirage = new QuestionTirage();
				question_tirage.setEstmarquee(rs.getBoolean("estMarquee"));;
				question_tirage.setNumordre(rs.getInt("numordre"));
				
				//Ajouter epreuve
				EpreuveDaoImpl epreuveDAO = EpreuveDaoImpl.getInstance();
				Epreuve epreuve = (Epreuve)epreuveDAO.selectById(rs.getInt("idEpreuve"));
				question_tirage.setEpreuve(epreuve);
								
				//Ajouter question
				QuestionDaoImpl questionDAO = QuestionDaoImpl.getInstance();
				Question question = (Question)questionDAO.selectById(rs.getInt("idQuestion"));
				question_tirage.setQuestion(question);
				
				
				question_tirages.add(question_tirage);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return question_tirages;
	}
	
	public void createReponse(Integer idEpreuve, Integer idQuestion,Integer idProposition) throws DaoException {
		Connection cnx=null;
		PreparedStatement rqt=null;
		
		try{
			cnx = getConnection();
			rqt=cnx.prepareStatement(insert_reponse);
			rqt.setInt(1, idProposition);
			rqt.setInt(2,idQuestion);
			rqt.setInt(3, idEpreuve);
			rqt.executeUpdate();
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
	
	public void deleteReponse(Integer idEpreuve, Integer idQuestion,Integer idProposition) throws DaoException {
		Connection cnx=null;
		PreparedStatement rqt=null;
		
		try{
			cnx = getConnection();
			rqt=cnx.prepareStatement(delete_reponse);
			rqt.setInt(1, idProposition);
			rqt.setInt(2,idQuestion);
			rqt.setInt(3, idEpreuve);
			rqt.executeUpdate();
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		
	}
	
	
	
}
