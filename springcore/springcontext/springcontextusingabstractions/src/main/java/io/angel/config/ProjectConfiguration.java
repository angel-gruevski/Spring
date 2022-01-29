package io.angel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"io.angel.proxies", "io.angel.services", "io.angel.repositories"})
public class ProjectConfiguration {}