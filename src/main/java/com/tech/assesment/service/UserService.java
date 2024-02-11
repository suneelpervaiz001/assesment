package com.tech.assesment.service;

import com.tech.assesment.entity.RetailUser;
import com.tech.assesment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<RetailUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<RetailUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public RetailUser createUser(RetailUser user) {
        return userRepository.save(user);
    }

    public RetailUser updateUser(Long id, RetailUser user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
