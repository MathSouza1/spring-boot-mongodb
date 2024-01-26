package com.matheuscardoso.springbootmongodb.domain.dto;

import com.matheuscardoso.springbootmongodb.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String name;
    private String email;

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
