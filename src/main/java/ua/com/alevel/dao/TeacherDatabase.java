package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import ua.com.alevel.model.Teacher;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class TeacherDatabase {
    private static final EntityManager ENTITY_MANAGER = JPAConfig.getEntityManager();
    private static TeacherDatabase instance;

    private TeacherDatabase() {
    }

    public static TeacherDatabase getInstance() {
        if (instance == null) {
            instance = new TeacherDatabase();
        }

        return instance;
    }

    public Set<Teacher> findTeacherByNameOrLastName(String name) {
        List<Teacher> teachers = ENTITY_MANAGER.createQuery("from Teacher as t where t.name = :name or t.lastName = :lastName")
                .setParameter("name", name)
                .setParameter("lastName", name)
                .getResultList();

        return (teachers.isEmpty()) ? Collections.emptySet() : new HashSet<>(teachers);
    }
}
