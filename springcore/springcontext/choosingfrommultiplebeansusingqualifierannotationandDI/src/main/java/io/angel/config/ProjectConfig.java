package io.angel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.angel.beans.Parrot;

@Configuration
@ComponentScan(basePackages = {"io.angel.beans"})
public class ProjectConfig {
    
    @Bean
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Kiki");
        return parrot;
    }

    @Bean
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }
}
