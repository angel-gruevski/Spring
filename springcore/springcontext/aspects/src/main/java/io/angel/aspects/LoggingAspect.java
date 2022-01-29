package io.angel.aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
  private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

  @Around("execution(* io.angel.services.CommentService.*(..))")
  public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

    logger.info("Executing log() method inside LoggingAspect");
    Object object = joinPoint.proceed();
    return object;
  }
}