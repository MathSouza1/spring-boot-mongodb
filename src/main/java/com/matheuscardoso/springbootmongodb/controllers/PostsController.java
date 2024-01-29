package com.matheuscardoso.springbootmongodb.controllers;

import com.matheuscardoso.springbootmongodb.domain.dto.UserDTO;
import com.matheuscardoso.springbootmongodb.domain.entities.Post;
import com.matheuscardoso.springbootmongodb.domain.entities.User;
import com.matheuscardoso.springbootmongodb.services.PostService;
import com.matheuscardoso.springbootmongodb.services.UserService;
import com.matheuscardoso.springbootmongodb.utils.DecodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{titlesearch}")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        title = DecodeUtil.decodeParam(title);
        List<Post> postsList = postService.findByTitle(title);
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }
}
