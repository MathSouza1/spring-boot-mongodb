package com.matheuscardoso.springbootmongodb.services;

import com.matheuscardoso.springbootmongodb.domain.entities.Post;
import com.matheuscardoso.springbootmongodb.exceptions.ObjectNotFoundException;
import com.matheuscardoso.springbootmongodb.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> posts = postRepository.findById(id);
        return posts.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }
}
