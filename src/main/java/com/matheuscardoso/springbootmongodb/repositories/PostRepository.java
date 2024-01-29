package com.matheuscardoso.springbootmongodb.repositories;

import com.matheuscardoso.springbootmongodb.domain.entities.Post;
import com.matheuscardoso.springbootmongodb.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, Long> {
    Optional<Post> findById(String id);
}
