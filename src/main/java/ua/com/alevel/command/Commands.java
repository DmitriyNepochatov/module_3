package ua.com.alevel.command;

public enum Commands {
    FIND_GROUPS_BY_NAME("Find groups by name", new FindGroupsByName()),
    COUNT_OF_STUDENTS_IN_EACH_GROUP("Count of students in each group", new CountOfStudentsInEachGroup()),
    AVERAGE_GPA_IN_EVERY_GROUP("Average gpa in every group", new AverageGpaInEveryGroup()),
    FIND_TEACHER_BY_NAME_OR_LASTNAME("Find teacher by name or lastname", new FindTeacherByNameOrLastName()),
    FIND_SUBJECT_WITH_BEST_AND_WORST_PERFORMANCE("Find subject with best and worst performance", new FindSubjectWithBestAndWorstPerformance()),
    FIND_STUDENTS_WHOSE_GPA_IS_GREATER_THAN("Find students whose gpa is greater than", new FindStudentsWhoseGpaIsGreaterThan()),
    EXIT("Exit", null);

    private final String name;
    private final Command command;

    Commands(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}
