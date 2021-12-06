package io.angel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.angel.main.Parrot;
import io.angel.main.Person;

@Configuration
public class ProjectConfig {
    
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Person person() {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot());
        return p;
    }
}