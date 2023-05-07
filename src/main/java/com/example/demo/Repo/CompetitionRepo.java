package com.example.demo.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.User;

public interface CompetitionRepo extends MongoRepository<User,String>{
	
	
	

}
