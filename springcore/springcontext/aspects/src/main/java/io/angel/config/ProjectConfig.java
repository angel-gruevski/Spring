package io.angel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"io.angel.services", "io.angel.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
    
}
