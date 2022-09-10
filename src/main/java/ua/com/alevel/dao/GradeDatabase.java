package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import javax.persistence.EntityManager;

public final class GradeDatabase {
    private static final EntityManager ENTITY_MANAGER = JPAConfig.getEntityManager();
    private static GradeDatabase instance;

    private GradeDatabase() {
    }

    public static GradeDatabase getInstance() {
        if (instance == null) {
            instance = new GradeDatabase();
        }

        return instance;
    }
}
