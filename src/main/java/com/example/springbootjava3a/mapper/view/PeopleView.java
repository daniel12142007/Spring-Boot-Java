package com.example.springbootjava3a.mapper.view;

import com.example.springbootjava3a.dto.response.PeopleResponse;
import com.example.springbootjava3a.model.People;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleView {
    public PeopleResponse map(People people) {
        PeopleResponse peopleResponse = new PeopleResponse();
        peopleResponse.setAge(people.getAge());
        peopleResponse.setName(people.getName());
        peopleResponse.setId(people.getId());
        peopleResponse.setRights(people.isRights());
        peopleResponse.setEmail(people.getEmail());
        peopleResponse.setRole(people.getRole());
        peopleResponse.setData_register(people.getData_register());
        peopleResponse.setBalance(people.getBalance());
        return peopleResponse;
    }

    public List<PeopleResponse> map(List<People> peopleList) {
        List<PeopleResponse> list = new ArrayList<>();
        for (People people : peopleList) {
            list.add(map(people));
        }
        return list;
    }
}