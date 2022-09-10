package ua.com.alevel.service;

import ua.com.alevel.dao.GroupDatabase;
import ua.com.alevel.model.Group;
import java.util.Map;
import java.util.Set;

public final class GroupService {
    private static GroupService instance;
    private static final GroupDatabase DATABASE = GroupDatabase.getInstance();

    private GroupService() {
    }

    public static GroupService getInstance() {
        if (instance == null) {
            instance = new GroupService();
        }

        return instance;
    }

    public Set<Group> findGroupsByName(String name) {
        if (name != null) {
            return DATABASE.findGroupsByName(name);
        }
        else {
            throw new IllegalArgumentException("String was null");
        }
    }

    public Map<String, Integer> countOfStudentsInEachGroup() {
        return DATABASE.countOfStudentsInEachGroup();
    }

    public Map<String, Double> averageGpaInEveryGroup() {
        return DATABASE.averageGpaInEveryGroup();
    }
}
