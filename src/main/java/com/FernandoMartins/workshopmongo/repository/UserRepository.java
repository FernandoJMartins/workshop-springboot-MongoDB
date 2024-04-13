package com.FernandoMartins.workshopmongo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.FernandoMartins.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository <User, String>{

}
