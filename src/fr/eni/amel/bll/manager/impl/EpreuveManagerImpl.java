package fr.eni.amel.bll.manager.impl;

import fr.eni.amel.bll.manager.EpreuveManager;

public class EpreuveManagerImpl implements EpreuveManager{
private static EpreuveManagerImpl instance;
    
    private EpreuveManagerImpl() {
        
    }
    
    public static EpreuveManagerImpl getInstance() {
        if(instance == null) {
            instance = new EpreuveManagerImpl();
        }
        return instance;
    }
}
