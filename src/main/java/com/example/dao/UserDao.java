package com.example.dao;

import com.example.model.Person;

import java.util.List;

public interface UserDao {
    void add(Person user);

    void delete(int id);

    Person update(Person user);

    Person findUserById(int id);

    List<Person> findAll();
}
