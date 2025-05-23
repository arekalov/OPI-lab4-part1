package com.arekalov.jsfgraph.db;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Properties;
import lombok.Getter;

/**
 * Utility class for handling JPA EntityManagerFactory.
 */
public class JPAUtils {
    @Getter
    private static final EntityManagerFactory factory;

    static {
        try {
            Properties info = new Properties();
            info.load(JPAUtils.class.getClassLoader().getResourceAsStream("/db.cfg"));
            factory = Persistence.createEntityManagerFactory("default", info);
        } catch (Throwable ex) {
            System.err.println("Something went wrong during initializing EclipseLink: " + ex);
            throw new ExceptionInInitializerError();
        }
    }

}
