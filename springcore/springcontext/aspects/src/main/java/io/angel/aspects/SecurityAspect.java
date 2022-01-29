package io.angel.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(io.angel.annotation.SecureMethod)")
    public Object logAnnotation(ProceedingJoinPoint joinPoint)
            throws Throwable {
        logger.info("Executing log() method inside SecurityAspect");
        Object returnedByMethod = joinPoint.proceed();
        return returnedByMethod;
    }
}