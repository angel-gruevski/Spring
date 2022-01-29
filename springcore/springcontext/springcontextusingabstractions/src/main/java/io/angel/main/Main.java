package io.angel.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import io.angel.config.ProjectConfiguration;
import io.angel.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}