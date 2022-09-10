package ua.com.alevel.dao;

import ua.com.alevel.config.JPAConfig;
import ua.com.alevel.model.Group;
import ua.com.alevel.model.Student;
import javax.persistence.EntityManager;
import java.util.*;

public final class GroupDatabase {
    private static final EntityManager ENTITY_MANAGER = JPAConfig.getEntityManager();
    private static GroupDatabase instance;

    private GroupDatabase() {
    }

    public static GroupDatabase getInstance() {
        if (instance == null) {
            instance = new GroupDatabase();
        }

        return instance;
    }

    public Set<Group> findGroupsByName(String name) {
        List<Group> groups = ENTITY_MANAGER.createQuery("from Group as g where g.name like :name", Group.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();

        return (groups.isEmpty()) ? Collections.emptySet() : new HashSet<>(groups);
    }

    public Map<String, Integer> countOfStudentsInEachGroup() {
        List<Object> map = ENTITY_MANAGER.createQuery("select s.group.name, count(s.id) from Student as s group by s.group.name")
                .getResultList();

        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        else {
            Map<String, Integer> count = new HashMap<>();
            map.forEach(pair -> {
                Object[] arr = (Object[]) pair;
                count.put((String) arr[0], ((Long) arr[1]).intValue());
            });

            return count;
        }
    }

    public Map<String, Double> averageGpaInEveryGroup() {
        List<Group> groups = ENTITY_MANAGER.createQuery("from Group")
                .getResultList();

        if (groups.isEmpty()) {
            return Collections.emptyMap();
        }
        else {
            Map<String, Double> result = new HashMap<>();

            groups.forEach(group -> {
                double averageInGroup = 0.0;

                for (Student student : group.getStudents()) {
                    Double averageStudent = ENTITY_MANAGER.createQuery("select avg(g.grade) from Grade as g where g.student.id = :id", Double.class)
                            .setParameter("id", student.getId())
                            .getSingleResult();

                    averageInGroup += averageStudent;
                }

                averageInGroup = averageInGroup / group.getStudents().size();
                result.put(group.getName(), averageInGroup);
            });

            return result;
        }
    }
}
