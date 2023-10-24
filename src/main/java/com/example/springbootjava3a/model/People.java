package com.example.springbootjava3a.model;

import com.example.springbootjava3a.model.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
    private int age;
    private LocalDateTime data_register;
    private boolean rights;
    private String balance;
    @Enumerated(EnumType.STRING)
    private Role role;
}