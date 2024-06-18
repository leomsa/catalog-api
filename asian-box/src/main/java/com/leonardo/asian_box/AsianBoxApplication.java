package com.leonardo.asian_box;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AsianBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsianBoxApplication.class, args);
	}

}
