package fr.eni.amel.dal;

import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface EpreuveDAO extends GenericDAO<Epreuve,Integer>{

	public List<Epreuve> selectByUtilisateur(Object id) throws DaoException;
}
