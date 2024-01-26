package com.matheuscardoso.springbootmongodb.services;

import com.matheuscardoso.springbootmongodb.domain.entities.User;
import com.matheuscardoso.springbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
