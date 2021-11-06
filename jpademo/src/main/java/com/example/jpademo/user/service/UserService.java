package com.example.jpademo.user.service;

import com.example.jpademo.user.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();

    public User FindUserById(long Id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);
}
