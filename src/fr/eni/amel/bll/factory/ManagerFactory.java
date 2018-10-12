package fr.eni.amel.bll.factory;

import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bll.manager.PromotionManager;
import fr.eni.amel.bll.manager.TestManager;
import fr.eni.amel.bll.manager.UtilisateurManager;
import fr.eni.amel.bll.manager.impl.EpreuveManagerImpl;
import fr.eni.amel.bll.manager.impl.PromotionManagerImpl;
import fr.eni.amel.bll.manager.impl.TestManagerImpl;
import fr.eni.amel.bll.manager.impl.UtilisateurManagerImpl;

public class ManagerFactory {
	
	public static EpreuveManager epreuveManager() {
        return EpreuveManagerImpl.getInstance();
    }
	
	public static UtilisateurManager utilisateurManager() {
		return UtilisateurManagerImpl.getInstance();
	}
	
	public static PromotionManager promotionManager() {
		return PromotionManagerImpl.getInstance();
	}
	public static TestManager testManager() {
		return TestManagerImpl.getInstance();
	}
	
}
