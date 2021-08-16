package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
/*Configuration/enabling the Mongo repository in our SpringbootApplication*/
//@EnableMongoRepositories("com.example.demo.dao")  
//@ComponentScan("com.example.*")
public class SpringmongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmongodbApplication.class, args);
	}

}
