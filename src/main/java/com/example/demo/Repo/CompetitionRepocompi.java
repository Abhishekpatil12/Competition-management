package com.example.demo.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.CompetitionReg;
import com.example.demo.model.User;

public interface CompetitionRepocompi extends MongoRepository<CompetitionReg,String>{

}
