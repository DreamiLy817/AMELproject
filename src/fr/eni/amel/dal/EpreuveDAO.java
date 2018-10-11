package fr.eni.amel.dal;

import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface EpreuveDAO extends GenericDAO{

	public Object selectByUtilisateur(Object id) throws DaoException;
}
