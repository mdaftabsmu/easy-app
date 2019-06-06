package com.easyapper.easyapperservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.easyapper.easyapperservices" })
@EnableMongoRepositories("com.easyapper.easyapperservices.repository")
@EntityScan("com.easyapper.easyapperservices.model")
public class EasyapperServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyapperServicesApplication.class, args);
	}

}
