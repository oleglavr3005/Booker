package com.softserve.edu.rs.data.apps;

public class ApplicationSourcesRepository {
    private static volatile ApplicationSourcesRepository instance = null;

	private ApplicationSourcesRepository() {
	}
	
    public static ApplicationSourcesRepository get() {
        if (instance == null) {
            synchronized (ApplicationSourcesRepository.class) {
                if (instance == null) {
                    instance = new ApplicationSourcesRepository();
                }
            }
        }
        return instance;
    }

    public ApplicationSources getLocalHostByFirefox() {
    	return ApplicationSources.get()
    			.setLoginUrl("http://localhost:8080/resources/login")
    			.setLogoutUrl("http://localhost:8080/resources/logout")
    			.setImplicitTimeOut(5)
    			.setBrowserName("firefox");
    }
    
    public ApplicationSources getTrainingLocalByFirefox() {
    	return ApplicationSources.get()
    			.setLoginUrl("http://java.training.local:8080/registrator/login")
    			.setLogoutUrl("http://java.training.local:8080/registrator/logout")
    			.setImplicitTimeOut(5)
    			.setBrowserName("firefox");
    }

    public ApplicationSources getHerokuByFirefox() {
    	return ApplicationSources.get()
    			.setLoginUrl("http://registrator.herokuapp.com/login")
    			.setLogoutUrl("http://registrator.herokuapp.com/logout")
    			.setImplicitTimeOut(5)
    			.setBrowserName("firefox");
    }

}
