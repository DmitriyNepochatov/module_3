package ua.com.alevel.command;

import ua.com.alevel.model.Student;
import ua.com.alevel.service.StudentService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

public class FindStudentsWhoseGpaIsGreaterThan implements Command {
    private static final StudentService STUDENT_SERVICE = StudentService.getInstance();
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void execute() {
        boolean check = false;
        while (!check) {
            try {
                System.out.print("\nEnter a GPA >> ");
                Double gpa = Double.parseDouble(BUFFERED_READER.readLine());

                if (gpa < 0.0) {
                    System.out.println("Incorrect GPA");
                    continue;
                }

                Set<Student> students = STUDENT_SERVICE.findStudentsWhoseGpaIsGreaterThan(gpa);

                if (students.isEmpty()) {
                    System.out.println("Not found");
                    continue;
                }

                System.out.println("\nStudents whose GPA is greater than " + gpa + " :");
                students.forEach(System.out::println);
                check = true;
            }
            catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
    }
}
