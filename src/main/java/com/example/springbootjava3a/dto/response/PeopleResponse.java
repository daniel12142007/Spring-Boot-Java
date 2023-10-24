package com.example.springbootjava3a.dto.response;

import com.example.springbootjava3a.model.enums.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PeopleResponse {
    private Long id;
    private String name;
    private String email;
    private int age;
    private LocalDateTime data_register;
    private boolean rights;
    private Role role;
    private String balance;
}