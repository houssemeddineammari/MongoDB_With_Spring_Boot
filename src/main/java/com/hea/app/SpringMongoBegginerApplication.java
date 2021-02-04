package com.hea.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.hea.repository")
@ComponentScan("com.hea.*")
public class SpringMongoBegginerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoBegginerApplication.class, args);
	}

}
