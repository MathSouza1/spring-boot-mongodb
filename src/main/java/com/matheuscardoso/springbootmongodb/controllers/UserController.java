package com.matheuscardoso.springbootmongodb.controllers;

import com.matheuscardoso.springbootmongodb.domain.dto.UserDTO;
import com.matheuscardoso.springbootmongodb.domain.entities.User;
import com.matheuscardoso.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
       List<User> userList = userService.findAll();
       List<UserDTO> userDTOList = userList.stream().map(UserDTO::new).toList();
       return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO userDTO) {
        User user = userService.insert(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        userService.delete(id);
        return new ResponseEntity<>("User deleted!", HttpStatus.NO_CONTENT);
    }
}
