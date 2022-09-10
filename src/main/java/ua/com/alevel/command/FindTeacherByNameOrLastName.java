package ua.com.alevel.command;

import ua.com.alevel.model.Teacher;
import ua.com.alevel.service.TeacherService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

public class FindTeacherByNameOrLastName implements Command {
    private static final TeacherService TEACHER_SERVICE = TeacherService.getInstance();
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute() {
        boolean check = false;
        while (!check) {
            try {
                System.out.print("\nEnter a teacher name or lastname >> ");
                String teacherNameOrLastname = BUFFERED_READER.readLine();

                if (teacherNameOrLastname.equals("")) {
                    System.out.println("String is empty");
                    continue;
                }

                Set<Teacher> teachers = TEACHER_SERVICE.findTeacherByNameOrLastName(teacherNameOrLastname);

                if (teachers.isEmpty()) {
                    System.out.println("Not found");
                    continue;
                }

                System.out.println("\nTeachers:");
                teachers.forEach(teacher -> {
                    System.out.println("\nTeacher: " + teacher.getName() + " " +
                            teacher.getLastName() + " " + teacher.getAge());
                    System.out.println("Subjects:");
                    teacher.getSubjects().forEach(System.out::println);
                });
                check = true;
            }
            catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
    }
}
