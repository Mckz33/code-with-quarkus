package org.acme.services;

import java.util.List;
import java.util.UUID;

import org.acme.exceptions.UserNotFoundException;
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

    public User findById(UUID userId) throws UserNotFoundException {
        return (User) User.findByIdOptional(userId).orElseThrow(UserNotFoundException::new);
    }

    public User updateUser(UUID userId, User user) throws UserNotFoundException {
        var userOp = findById(userId);
        userOp.age = user.age;
        userOp.name = user.name;
        User.persist(userOp);
        return user;
    }

    public void deleteById(UUID userId, User user) throws UserNotFoundException {
        var userOp = findById(userId);
        User.deleteById(userOp.id);
    }
    
}
