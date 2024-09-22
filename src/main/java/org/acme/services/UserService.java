package org.acme.services;

import java.util.List;
import java.util.UUID;

import org.acme.exceptions.UserNotFoundException;
import org.acme.models.UserModel;
import org.acme.repositories.UserRepository;
import org.glassfish.expressly.stream.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel userModel) {
        userRepository.persist(userModel);
        return userModel;
    }

    public List<UserModel> findAll(Integer page, Integer pageSize) {
        return userRepository.findAll().page(page, pageSize).list();
    }

    public UserModel findById(UUID userId) throws UserNotFoundException {
        return userRepository.findByIdOptional(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado com o ID: " + userId));
    }

    @Transactional
    public UserModel updateUser(UUID userId, UserModel userModel) throws UserNotFoundException {
        UserModel existingUser = findById(userId);
        existingUser.setName(userModel.getName());
        existingUser.setAge(userModel.getAge());
        return existingUser;
    }


    public void deleteById(UUID userId, UserModel userModel) throws UserNotFoundException {
        var userOp = findById(userId);
        userRepository.deleteById(userOp.getId());
    }
    
}
