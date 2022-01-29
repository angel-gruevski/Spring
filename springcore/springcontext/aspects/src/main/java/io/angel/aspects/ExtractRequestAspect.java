package io.angel.aspects;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.angel.model.Comment;

@Component
@Aspect
@Order(3)
public class ExtractRequestAspect {
    private Logger logger = Logger.getLogger(ExtractRequestAspect.class.getName());
    
    @Before("execution(String io.angel.services.CommentService.publishComment(..))")
    public void extractRequest(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Comment comment = (Comment) args[0];
        logger.info(comment.toString());
    }

    @Before("@annotation(io.angel.annotation.ModifyRequest)")
    public void modifyRequest(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Comment comment = (Comment) args[0];
        comment.setText("Modified comment");
    }
}