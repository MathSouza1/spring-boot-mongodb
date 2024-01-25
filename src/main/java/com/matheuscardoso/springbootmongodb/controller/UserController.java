package com.matheuscardoso.springbootmongodb.controller;

import com.matheuscardoso.springbootmongodb.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = new ArrayList<>();
        User userMaria = new User("1001", "Maria Brown", "maria@email.com");
        User userAlex = new User("1002", "Alex Green", "alex@email.com");
        userList.addAll(Arrays.asList(userMaria, userAlex));
        return new ResponseEntity<>(userList, HttpStatus.CREATED);
    }
}
