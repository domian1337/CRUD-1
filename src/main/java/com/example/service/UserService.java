package com.example.service;

import com.example.model.Person;

import java.util.List;

public interface UserService {
    void add(Person user);

    void delete(int id);

    void update(Person user);

    Person findUserById(int id);

    List<Person> findAll();
}