package com.mendes.service;

import com.mendes.entity.User;
import com.mendes.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by mendesmustafa on 11.02.2021.
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User model) {
        User user = new User();
        if (model.getId() != null) {
            Optional<User> userOptional = userRepository.findById(model.getId());
            if (userOptional.isPresent()) {
                user = userOptional.get();
            }
        }
        fillUser(user, model);
        userRepository.save(user);
        return user;
    }

    private void fillUser(User user, User model) {
        user.setName(model.getName());
        user.setSurname(model.getSurname());
        user.setEmail(model.getEmail());
        user.setUserName(model.getUserName());
        user.setPassword(model.getPassword());
    }
}
