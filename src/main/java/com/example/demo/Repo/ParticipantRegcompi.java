package com.example.demo.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.ParticipantReg;
import com.example.demo.model.User;

public interface ParticipantRegcompi extends MongoRepository<ParticipantReg,String>{

}

