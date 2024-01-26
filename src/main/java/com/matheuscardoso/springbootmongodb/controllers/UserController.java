package com.matheuscardoso.springbootmongodb.controllers;

import com.matheuscardoso.springbootmongodb.domain.dto.UserDTO;
import com.matheuscardoso.springbootmongodb.domain.entities.User;
import com.matheuscardoso.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
       List<User> userList = userService.findAll();
       List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).toList();
        return new ResponseEntity<>(userDTOList, HttpStatus.CREATED);
    }
}
