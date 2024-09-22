package org.acme.services;

import java.util.List;

import org.acme.models.User;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {

    public User createUser(User user) {
        User.persist(user);
        return user;
    }

    public List<User> findAll(Integer page, Integer pageSize) {
        return User.findAll().page(page, pageSize).list();
    }
    
}
