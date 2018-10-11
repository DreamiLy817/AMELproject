package fr.eni.amel.bll.factory;

import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.impl.EpreuveManagerImpl;

public class ManagerFactory {
	public static EpreuveManager epreuveManager() {
        return EpreuveManagerImpl.getInstance();
    }
}
