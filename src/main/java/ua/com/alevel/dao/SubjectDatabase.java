package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SubjectDatabase {
    private static final EntityManager ENTITY_MANAGER = JPAConfig.getEntityManager();
    private static SubjectDatabase instance;

    private SubjectDatabase() {
    }

    public static SubjectDatabase getInstance() {
        if (instance == null) {
            instance = new SubjectDatabase();
        }

        return instance;
    }

    public Map<String, Double> findSubjectWithBestPerformance() {
        List<Object> subjects = ENTITY_MANAGER.createQuery("select g.subject.name, avg(g.grade)  from Grade as g group by g.subject.name")
                .getResultList();

        if (subjects.isEmpty()) {
            return Collections.emptyMap();
        }
        else {
            Object[] pair = new Object[2];
            pair[1] = 0.0;
            subjects.forEach(pairInList -> {
                Object[] arr = (Object[]) pairInList;
                if ((Double) arr[1] > (Double) pair[1]) {
                    pair[0] = arr[0];
                    pair[1] = arr[1];
                }
            });

            HashMap<String, Double> result = new HashMap<>();
            result.put((String) pair[0], (Double) pair[1]);
            return result;
        }
    }

    public Map<String, Double> findSubjectWithWorstPerformance() {
        List<Object> subjects = ENTITY_MANAGER.createQuery("select g.subject.name, avg(g.grade)  from Grade as g group by g.subject.name")
                .getResultList();

        if (subjects.isEmpty()) {
            return Collections.emptyMap();
        }
        else {
            Object[] pair = new Object[2];
            pair[1] = 9999.0;
            subjects.forEach(pairInList -> {
                Object[] arr = (Object[]) pairInList;
                if ((Double) arr[1] < (Double) pair[1]) {
                    pair[0] = arr[0];
                    pair[1] = arr[1];
                }
            });

            HashMap<String, Double> result = new HashMap<>();
            result.put((String) pair[0], (Double) pair[1]);
            return result;
        }
    }
}
