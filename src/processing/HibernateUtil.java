package processing;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.io.File;
public class HibernateUtil {
    final static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            logger.info("Init Hibernate");
            Configuration cfg = new Configuration();
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
            sessionFactory =cfg.configure().buildSessionFactory();
        } catch (Throwable ex) {
            logger.error("Error while init Hibernate");
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
