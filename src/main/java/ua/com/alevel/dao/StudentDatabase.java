package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import ua.com.alevel.model.Student;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class StudentDatabase {
    private static final EntityManager ENTITY_MANAGER = JPAConfig.getEntityManager();
    private static StudentDatabase instance;

    private StudentDatabase() {
    }

    public static StudentDatabase getInstance() {
        if (instance == null) {
            instance = new StudentDatabase();
        }

        return instance;
    }

    public Set<Student> findStudentsWhoseGpaIsGreaterThan(double gpa) {
        List<Student> students = ENTITY_MANAGER.createQuery("from Student as stud where (select avg(g.grade) from Grade as g where g.student.id = stud.id) > :gpa")
                .setParameter("gpa", gpa)
                .getResultList();

        return (students.isEmpty()) ? Collections.emptySet() : new HashSet<>(students);
    }
}
