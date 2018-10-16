package fr.eni.amel.bll.manager;

import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.tp.web.common.bll.exception.ManagerException;

public interface ProfilManager {

	public List<Profil> getProfils() throws ManagerException ;
}
