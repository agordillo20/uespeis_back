package com.uespeis.application;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EntityScan({ "com.uespeis.model", "com.uespeis.service_impl" })
@ComponentScan({ "com.uespeis.controller", "com.uespeis.service_impl" })
@EnableJpaRepositories({ "com.uespeis.repository" })
public class UespeisApplication {

    public static void main(final String[] args) {
        SpringApplication.run(UespeisApplication.class, args);
    }
}
