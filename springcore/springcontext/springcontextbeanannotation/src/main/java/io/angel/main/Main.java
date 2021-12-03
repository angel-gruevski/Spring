package io.angel.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.angel.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot parrot1 = context.getBean("koko", Parrot.class);
        Parrot parrot2 = context.getBean("parrot2", Parrot.class);
        Parrot parrot3 = context.getBean("parrot3", Parrot.class);
    }
}