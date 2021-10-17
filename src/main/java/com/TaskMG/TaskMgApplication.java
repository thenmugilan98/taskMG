package com.TaskMG;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EntityScan(basePackages = "com.TaskNG.entity")
public class TaskMgApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMgApplication.class, args);
	}

}
