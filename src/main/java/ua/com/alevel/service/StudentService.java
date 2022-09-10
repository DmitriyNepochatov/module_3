package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDatabase;
import ua.com.alevel.model.Student;
import java.util.Set;

public final class StudentService {
    private static StudentService instance;
    private static final StudentDatabase DATABASE = StudentDatabase.getInstance();

    private StudentService() {
    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }

        return instance;
    }

    public Set<Student> findStudentsWhoseGpaIsGreaterThan(double gpa) {
        if (gpa >= 0) {
            return DATABASE.findStudentsWhoseGpaIsGreaterThan(gpa);
        }
        else {
            throw new IllegalArgumentException("Incorrect GPA");
        }
    }
}
