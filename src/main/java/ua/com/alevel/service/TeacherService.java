package ua.com.alevel.service;

import ua.com.alevel.dao.TeacherDatabase;
import ua.com.alevel.model.Teacher;
import java.util.Set;

public final class TeacherService {
    private static TeacherService instance;
    private static final TeacherDatabase DATABASE = TeacherDatabase.getInstance();

    private TeacherService() {
    }

    public static TeacherService getInstance() {
        if (instance == null) {
            instance = new TeacherService();
        }

        return instance;
    }

    public Set<Teacher> findTeacherByNameOrLastName(String name) {
        if (name != null) {
            return DATABASE.findTeacherByNameOrLastName(name);
        }
        else {
            throw new IllegalArgumentException("String was null");
        }
    }
}
