package com.chrisferdev.ecommerce.backend.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private Integer username;
    private Integer firstName;
    private Integer lastName;
    private Integer email;
    private Integer address;
    private Integer cellphone;
    private Integer password;
    private UserType userType;
    private LocalDateTime dateCreated;

}
