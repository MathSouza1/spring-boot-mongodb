package com.matheuscardoso.springbootmongodb.domain.entities;

import com.matheuscardoso.springbootmongodb.domain.dto.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Document
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;
    @DBRef(lazy = true)
    private List<Post> postList = new ArrayList<>();

    public User(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String id, UserDTO userDTO) {
        this.id = id;
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }
}
