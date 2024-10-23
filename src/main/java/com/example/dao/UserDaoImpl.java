package com.example.dao;

import com.example.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void add(Person user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        em.remove(em.find(Person.class, id));
    }

    @Transactional
    @Override
    public Person update(Person user) {
        return em.merge(user);
    }

    @Override
    public Person findUserById(int id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }
}
