package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Repo.CompetitionRepo;
import com.example.demo.model.User;

@SpringBootApplication
public class CompetitionManagementApplication implements CommandLineRunner{
	
	@Autowired
	CompetitionRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(CompetitionManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repo.save(new User("7776881149","a123","Seth Rollins"));
		
		System.out.print("Data saved");
		
		
	}

}
