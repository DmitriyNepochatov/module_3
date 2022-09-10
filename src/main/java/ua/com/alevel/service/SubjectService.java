package ua.com.alevel.service;

import ua.com.alevel.dao.SubjectDatabase;
import java.util.Map;

public final class SubjectService {
    private static SubjectService instance;
    private static final SubjectDatabase DATABASE = SubjectDatabase.getInstance();

    private SubjectService() {
    }

    public static SubjectService getInstance() {
        if (instance == null) {
            instance = new SubjectService();
        }

        return instance;
    }

    public Map<String, Double> findSubjectWithBestPerformance() {
        return DATABASE.findSubjectWithBestPerformance();
    }

    public Map<String, Double> findSubjectWithWorstPerformance() {
        return DATABASE.findSubjectWithWorstPerformance();
    }
}
