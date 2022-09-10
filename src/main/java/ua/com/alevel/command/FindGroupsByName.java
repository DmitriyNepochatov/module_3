package ua.com.alevel.command;

import ua.com.alevel.model.Group;
import ua.com.alevel.service.GroupService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

public class FindGroupsByName implements Command {
    private static final GroupService GROUP_SERVICE = GroupService.getInstance();
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute() {
        boolean check = false;
        while (!check) {
            try {
                System.out.print("\nEnter a group name >> ");
                String groupName = BUFFERED_READER.readLine();

                if (groupName.equals("")) {
                    System.out.println("String is empty");
                    continue;
                }

                Set<Group> groups = GROUP_SERVICE.findGroupsByName(groupName);

                if (groups.isEmpty()) {
                    System.out.println("Not found");
                    continue;
                }

                System.out.println("\nGroups:");
                groups.forEach(group -> {
                    System.out.println("\nGroup: " + group.getName());
                    System.out.println("Students:");
                    group.getStudents().forEach(System.out::println);
                });
                check = true;
            }
            catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
    }
}
