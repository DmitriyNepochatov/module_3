package ua.com.alevel.command;

import ua.com.alevel.service.SubjectService;
import java.util.Map;

public class FindSubjectWithBestAndWorstPerformance implements Command {
    private static final SubjectService SUBJECT_SERVICE = SubjectService.getInstance();

    @Override
    public void execute() {
        Map<String, Double> best = SUBJECT_SERVICE.findSubjectWithBestPerformance();
        Map<String, Double> worst = SUBJECT_SERVICE.findSubjectWithWorstPerformance();

        if (best.isEmpty() || worst.isEmpty()) {
            System.out.println("\nNot found");
        }
        else {
            System.out.println("\nSubject with best performance:");
            print(best);

            System.out.println("\nSubject with worst performance:");
            print(worst);
        }
    }

    private void print(Map<String, Double> map) {
        Map.Entry<String, Double> entry = map.entrySet().iterator().next();
        System.out.println(entry.getKey() + " : " + entry.getValue());
    }
}
