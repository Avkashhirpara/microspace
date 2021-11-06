package com.example.jpademo.user.service;

import com.example.jpademo.user.model.User;
import com.example.jpademo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getUserList() {
        return userRepo.findAll();
    }

    @Override
    public User FindUserById(long Id) {
        return userRepo.getById(Id);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void edit(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }
}
