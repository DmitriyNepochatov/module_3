package ua.com.alevel.config;

import org.flywaydb.core.Flyway;
import ua.com.alevel.dao.*;

public final class FlywayConfig {
    private static final String URL = "jdbc:postgresql://ec2-63-32-248-14.eu-west-1.compute.amazonaws.com:5432/d4rm6pmln3qolm";
    private static final String USER = "zjgskmyyallykn";
    private static final String PASSWORD = "757c978eaf7482dc056eefa1157780028fc8f843fa32c5589b807bd6927c6294";
    private static final String SCHEMA = "public";
    private static final String LOCATION = "db/migration";

    private FlywayConfig() {
    }

    public static void initialize() {
        Flyway flyway = Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .baselineOnMigrate(true)
                .schemas(SCHEMA)
                .locations(LOCATION)
                .load();
        flyway.clean();
        StudentDatabase.getInstance();
        GroupDatabase.getInstance();
        TeacherDatabase.getInstance();
        SubjectDatabase.getInstance();
        GradeDatabase.getInstance();
        flyway.migrate();
    }
}
