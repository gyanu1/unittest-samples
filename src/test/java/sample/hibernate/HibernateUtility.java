package sample.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Utility Class to obtain hibernate SessionFactory
 * 
 * @author gyanu
 * **/

public class HibernateUtility {
	private static final SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
	    configuration.configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	   
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
