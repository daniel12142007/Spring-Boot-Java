package com.example.springbootjava3a.api;

import com.example.springbootjava3a.dto.request.PeopleRequest;
import com.example.springbootjava3a.dto.response.PeopleResponse;
import com.example.springbootjava3a.service.PeopleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/people")
public class PeopleApi {
    private final PeopleService peopleService;

    @PostMapping("save/people")
    @Operation(summary = "save", description = "saves is people for all")
    public PeopleResponse save(@RequestBody PeopleRequest request) {
        return peopleService.save(request);
    }

    @GetMapping("find/by/{id}")
    public PeopleResponse findById(@PathVariable Long id) {
        return peopleService.findById(id);
    }

    @GetMapping("find/by/all")
    public List<PeopleResponse> findByAll() {
        return peopleService.findALl();
    }

    @DeleteMapping("delete/by/{id}")
    public String deleteById(@PathVariable Long id) {
        return peopleService.deleteById(id);
    }

    @DeleteMapping("delete/by/all")
    public String deleteByAll() {
        return peopleService.deleteAll();
    }

    @PutMapping("update/by/{id}")
    public PeopleResponse updateById(@PathVariable Long id, @RequestBody PeopleRequest peopleRequest) {
        return peopleService.update(id, peopleRequest);
    }

}