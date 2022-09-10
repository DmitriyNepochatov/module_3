package ua.com.alevel.command;

import ua.com.alevel.service.GroupService;
import java.util.Map;

public class AverageGpaInEveryGroup implements Command {
    private static final GroupService GROUP_SERVICE = GroupService.getInstance();

    @Override
    public void execute() {
        Map<String, Double> map = GROUP_SERVICE.averageGpaInEveryGroup();
        if (map.isEmpty()) {
            System.out.println("\nNot found");
        }
        else {
            System.out.println("\nAverage gpa in every group:");
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
