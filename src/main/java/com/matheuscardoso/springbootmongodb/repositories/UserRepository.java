package com.matheuscardoso.springbootmongodb.repositories;

import com.matheuscardoso.springbootmongodb.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findById(String id);

    void deleteById(String id);
}
