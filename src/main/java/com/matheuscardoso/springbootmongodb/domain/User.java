package com.matheuscardoso.springbootmongodb.domain;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User implements Serializable {
    private String id;
    private String name;
    private String email;
}
