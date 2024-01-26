package com.matheuscardoso.springbootmongodb.services;

import com.matheuscardoso.springbootmongodb.domain.dto.UserDTO;
import com.matheuscardoso.springbootmongodb.domain.entities.User;
import com.matheuscardoso.springbootmongodb.exceptions.ObjectNotFoundException;
import com.matheuscardoso.springbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.insert(user);
    }
}
