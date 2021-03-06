package io.angel.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.angel.config.ProjectConfig;
import io.angel.services.CommentService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var cs1 = c.getBean("commentService", CommentService.class);
        var cs2 = c.getBean("commentService", CommentService.class);

        boolean b1 = cs1 == cs2;
        System.out.println(b1);
    }
}
