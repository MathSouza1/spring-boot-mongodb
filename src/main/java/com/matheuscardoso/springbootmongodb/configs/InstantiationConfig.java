package com.matheuscardoso.springbootmongodb.configs;

import com.matheuscardoso.springbootmongodb.domain.dto.AuthorDTO;
import com.matheuscardoso.springbootmongodb.domain.dto.CommentDTO;
import com.matheuscardoso.springbootmongodb.domain.entities.Post;
import com.matheuscardoso.springbootmongodb.domain.entities.User;
import com.matheuscardoso.springbootmongodb.repositories.PostRepository;
import com.matheuscardoso.springbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class InstantiationConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        userRepository.deleteAll();

        User firstUser = new User(null, "Maria Brown", "maria@gmail.com");
        User secondUser = new User(null, "Alex Green", "alex@gmail.com");
        User thirdUser = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(firstUser, secondUser, thirdUser));

        CommentDTO firstComment = new CommentDTO("Boa viagem mano!", simpleDateFormat.parse("21/03/2018"), new AuthorDTO(secondUser));
        CommentDTO secondComment = new CommentDTO("Aproveite!", simpleDateFormat.parse("22/03/2018"), new AuthorDTO(thirdUser));
        CommentDTO thirdComment = new CommentDTO("Tenha um ótimo dia!", simpleDateFormat.parse("23/03/2018"), new AuthorDTO(secondUser));

        Post firstPost = new Post(null, simpleDateFormat.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(firstUser), Arrays.asList(firstComment, secondComment));
        Post secondPost = new Post(null, simpleDateFormat.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(firstUser), Arrays.asList(thirdComment));
        postRepository.saveAll(Arrays.asList(firstPost, secondPost));

        firstUser.getPostList().add(firstPost);
        firstUser.getPostList().add(secondPost);
        userRepository.save(firstUser);
    }
}
