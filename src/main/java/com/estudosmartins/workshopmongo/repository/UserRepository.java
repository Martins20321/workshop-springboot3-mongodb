package com.estudosmartins.workshopmongo.repository;

import com.estudosmartins.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByNameContainingIgnoreCase(String text);
}
