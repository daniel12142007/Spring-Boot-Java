package com.example.springbootjava3a.mapper.edit;

import com.example.springbootjava3a.dto.request.PeopleRequest;
import com.example.springbootjava3a.model.People;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PeopleEdit {
    public People create(PeopleRequest request){
        People people = new People();
        people.setAddress(request.getAddress());
        people.setName(request.getName());
        people.setAge(request.getAge());
        people.setEmail(request.getEmail());
        people.setRole(request.getRole());
        people.setPassword(request.getPassword());
        people.setData_register(LocalDateTime.now());
        return people;
    }
    public People update(PeopleRequest request,People people){
        people.setAddress(request.getAddress());
        people.setName(request.getName());
        people.setAge(request.getAge());
        people.setEmail(request.getEmail());
        people.setRole(request.getRole());
        people.setPassword(request.getPassword());
        people.setData_register(people.getData_register());
        return people;
    }
}