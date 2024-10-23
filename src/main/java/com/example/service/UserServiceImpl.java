package com.example.service;

import com.example.dao.UserDao;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(Person user) {
        userDao.add(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(Person user) {
        userDao.update(user);
    }

    @Override
    public Person findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<Person> findAll() {
        return userDao.findAll();
    }
}
