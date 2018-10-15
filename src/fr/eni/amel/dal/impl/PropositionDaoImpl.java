package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Proposition;
import fr.eni.amel.dal.PropositionDao;
import fr.eni.amel.test.bo.ConnectBDD;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class PropositionDaoImpl implements PropositionDao {

	private static final String SELECT_ALL_PROPOSITIONS_BY_QUESTION = "SELECT idProposition, enonce, estBonne FROM PROPOSITION WHERE idQuestion=?";
	private static final String SELECT_PROPOSITION_QUERY ="SELECT idProposition, enonce, estBonne FROM PROPOSITION WHERE idProposition=?";
	
	private static PropositionDaoImpl instance;
	
	private Connection connection;
	
	public static PropositionDaoImpl getInstance() {
		if (instance == null) {
			instance = new PropositionDaoImpl();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		// test la connexion si null
		if (connection == null) {
			connection = ConnectBDD.jdbcConnexion();
		}
		return connection;
	}
	@Override
	public Proposition insert(Proposition element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Proposition element) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Proposition selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Proposition proposition = null;
		try{
			//connection = MSSQLConnectionFactory.get();
			connection = getConnection();
			statement = connection.prepareStatement(SELECT_PROPOSITION_QUERY);
			resultSet = statement.executeQuery();
			
			if(resultSet.next()){
				proposition = new Proposition();
				proposition.setIdProposition(resultSet.getInt("idProposition"));
				proposition.setEnonce(resultSet.getString("enonce"));
				proposition.setEstBonne(resultSet.getBoolean("estBonne"));
			}
		}catch(SQLException e){
			throw new DaoException(e.getMessage(),e);
		}
		finally{
			ResourceUtil.safeClose(resultSet, statement, connection);
			this.connection = null;
		}
		return proposition;
	}

	@Override
	public List<Proposition> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proposition> listePropositionsParQuestion(Integer idQuestion) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Proposition> listePropositions = new ArrayList();
		Proposition proposition = null;

		try {
			//connection = MSSQLConnectionFactory.get();
			connection = getConnection();
			statement = connection.prepareStatement(SELECT_ALL_PROPOSITIONS_BY_QUESTION);
			statement.setInt(1, idQuestion);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				proposition = new Proposition();
				proposition.setIdProposition(resultSet.getInt("idProposition"));
				proposition.setEnonce(resultSet.getString("enonce"));
				proposition.setEstBonne(resultSet.getBoolean("estBonne"));
				listePropositions.add(proposition);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement,connection);
			this.connection = null;
		}

		return listePropositions;

	}

}
