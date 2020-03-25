package com.binary.mindset.tasklistmanagement.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.binary.mindset.tasklistmanagement.crud.repository")
@EntityScan(basePackages = "com.binary.mindset.tasklistmanagement.crud.entity")
public class DatabaseConfig {
}
