package com.example.snap.SnapProject;

import com.example.snap.SnapProject.model.Driver;
import com.example.snap.SnapProject.persistance.MongoDb.MongoDb;
import com.mongodb.client.MongoCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnapProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SnapProjectApplication.class, args);

	}

}
