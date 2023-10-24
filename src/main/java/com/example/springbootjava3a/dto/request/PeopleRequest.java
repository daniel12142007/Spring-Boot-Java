package com.example.springbootjava3a.dto.request;

import com.example.springbootjava3a.model.enums.Role;
import lombok.Data;

@Data
public class PeopleRequest {
    private String name;
    private String email;
    private String password;
    private String address;
    private int age;
    private Role role;
}