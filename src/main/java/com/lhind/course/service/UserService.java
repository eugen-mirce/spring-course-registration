package com.lhind.course.service;

import com.lhind.course.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(int id);
    User findById(int id);
    List<User> findAll();
}
