package ua.com.alevel.command;

import ua.com.alevel.service.GroupService;
import java.util.Map;

public class CountOfStudentsInEachGroup implements Command {
    private static final GroupService GROUP_SERVICE = GroupService.getInstance();

    @Override
    public void execute() {
        Map<String, Integer> map = GROUP_SERVICE.countOfStudentsInEachGroup();
        if (map.isEmpty()) {
            System.out.println("\nNot found");
        }
        else {
            System.out.println("\nCount of students in each group:");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
