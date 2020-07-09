package com.example.snap.SnapProject;

import com.example.snap.SnapProject.model.Driver;
import com.example.snap.SnapProject.persistance.driverDaoMongoDb.DriverDao;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SnapProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(SnapProjectApplication.class, args);

	}

}
