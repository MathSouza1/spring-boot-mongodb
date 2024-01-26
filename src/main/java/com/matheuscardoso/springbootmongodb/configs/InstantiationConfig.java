package com.matheuscardoso.springbootmongodb.configs;

import com.matheuscardoso.springbootmongodb.domain.entities.User;
import com.matheuscardoso.springbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class InstantiationConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User firstUser = new User(null, "Maria Brown", "maria@gmail.com");
        User secondUser = new User(null, "Alex Green", "alex@gmail.com");
        User thirdUser = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(firstUser, secondUser, thirdUser));
    }
}
