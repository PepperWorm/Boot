package com.example.boot.service;

import com.example.boot.models.User;
import com.example.boot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        repository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User user) {
        user.setId(id);
        repository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        repository.deleteById(id);
    }
}
