package com.pw.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.pw.demo.Repository.UserRepository;
import com.pw.demo.Dto.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    UserRepository repository;

    public User saveUser(User user) {
    return repository.save(user);
    }

    public Optional<User> updateUser(User user, int id) {
        return repository.findById(id);
    }

    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

    public List<User> getAllUser() {
        return repository.findAll();
    }

    public Optional<User> deleteUser(int id) {
        return repository.findById(id);
    }

}

