package com.example.springbootjava3a.repository;

import com.example.springbootjava3a.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PeopleRepository extends JpaRepository<People,Long> {
}