package io.angel.main;

import java.util.function.Supplier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.angel.beans.Parrot;
import io.angel.config.ProjectConfig;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = new Parrot();
        p.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> p;

        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        Parrot parrot = context.getBean(Parrot.class);
    }
}