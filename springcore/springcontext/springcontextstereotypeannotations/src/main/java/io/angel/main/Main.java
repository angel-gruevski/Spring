package io.angel.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.angel.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot = context.getBean(Parrot.class);
    }
}
