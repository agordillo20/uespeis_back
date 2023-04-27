package com.uespeis.application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@SpringBootApplication
@EntityScan({"com.uespeis.model","com.uespeis.service_impl"})
@ComponentScan({"com.uespeis.controller","com.uespeis.service_impl"})
@EnableJpaRepositories("com.uespeis.repository")
public class UespeisApplication {

	public static void main(String[] args) {
		SpringApplication.run(UespeisApplication.class, args);
	}
	
}
