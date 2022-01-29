package io.angel.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.angel.memorydatabase.Database;
import io.angel.models.Author;
import io.angel.models.Post;
import io.angel.models.Session;
import io.angel.models.User;
import io.angel.services.PostService;

@Component
@Aspect
public class PostServiceAspect {
    
    @Autowired
    private Session session;
    @Autowired
    private Database database;
    @Autowired
    private PostService postService;

    @Around("@annotation(io.angel.annotations.DeletePostPermission)")
    // @Around("execution(* io.angel.services.PostService.deletePost(..))")
    public void checkPermissionForDeletingPost(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] arguments = joinPoint.getArgs();
        String id = (String) arguments[0];

        Post post = postService.getPost(id);

        Author author = (Author) session.getUserSession();

        System.out.println("Aspect Author " + author.getFullName());
        System.out.println("Aspect Author " + post.getAuthor());
        if(post.getAuthor().equals(author)) {
            joinPoint.proceed();
        }
    }
}