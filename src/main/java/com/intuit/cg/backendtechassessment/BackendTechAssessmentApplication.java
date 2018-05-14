package com.intuit.cg.backendtechassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackages = "com.intuit.cg.backendtechassessment.repository")
public class BackendTechAssessmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendTechAssessmentApplication.class, args);
	}
}
