package com.example.springbootjava3a.service;

import com.example.springbootjava3a.dto.request.PeopleRequest;
import com.example.springbootjava3a.dto.response.PeopleResponse;
import com.example.springbootjava3a.error.MyError;
import com.example.springbootjava3a.mapper.edit.PeopleEdit;
import com.example.springbootjava3a.mapper.view.PeopleView;
import com.example.springbootjava3a.model.People;
import com.example.springbootjava3a.repository.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleService {
    private final PeopleRepository peopleRepository;
    private final PeopleEdit peopleEdit;
    private final PeopleView peopleView;

    public PeopleResponse save(PeopleRequest peopleRequest) {
        People people = peopleEdit.create(peopleRequest);
        people.setRights(people.getAge() >= 18);
        switch (people.getRole()) {
            case USER -> people.setBalance("10.000 SUM");
            case SNIPER -> people.setBalance("10.000 USD");
            case ADMIN -> people.setBalance(peopleRepository.findAll().size() * 10 + " $");
            case HOMELESS -> people.setBalance("100 SUM");
            default -> people.setBalance("get way");
        }
        return peopleView.map(peopleRepository.save(people));
    }

    public List<PeopleResponse> findALl() {
        return peopleView.map(peopleRepository.findAll());
    }

    public PeopleResponse findById(Long id) {
        return peopleView.map(peopleRepository.findById(id).orElseThrow(MyError::new));
    }

    public PeopleResponse update(Long id, PeopleRequest peopleRequest) {
//        People people = peopleRepository.findById(id).orElseThrow(MyError::new);
//        peopleRepository.save(people);
//        return peopleView.map(people);
        return peopleView.map(peopleEdit.update(peopleRequest, peopleRepository.findById(id).orElseThrow(MyError::new)));
    }

    public String deleteById(Long id) {
        peopleRepository.deleteById(id);
        return "deleted!";
    }

    public String deleteAll() {
        peopleRepository.deleteAll();
        return "deleted all!";
    }
}