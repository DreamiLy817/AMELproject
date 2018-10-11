package fr.eni.amel.bll.factory;

import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.UtilisateurManager;
import fr.eni.amel.bll.manager.impl.EpreuveManagerImpl;
import fr.eni.amel.bll.manager.impl.UtilisateurManagerImpl;

public class ManagerFactory {
	
	public static EpreuveManager epreuveManager() {
        return EpreuveManagerImpl.getInstance();
    }
	
	public static UtilisateurManager utilisateurManager() {
		return UtilisateurManagerImpl.getInstance();
	}
}
