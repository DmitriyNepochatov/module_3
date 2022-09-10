package ua.com.alevel;

import ua.com.alevel.config.FlywayConfig;
import ua.com.alevel.controller.Controller;

public class Main {
    public static void main(String[] args) {
        FlywayConfig.initialize();

        Controller.run();
    }
}
