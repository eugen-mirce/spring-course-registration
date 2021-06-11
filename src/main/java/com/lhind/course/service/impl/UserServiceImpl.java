package com.lhind.course.service.impl;

import com.lhind.course.exceptions.UserServiceException;
import com.lhind.course.model.User;
import com.lhind.course.repository.UserRepository;
import com.lhind.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        //TODO Check if exists firstName-lastName combination
        if(userRepository.findByFirstNameAndLastName(user.getFirstName(),user.getLastName()) != null)
            throw new UserServiceException("User with this credentials exists.");
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User u = findById(user.getId());
        if(u == null) return createUser(user);

        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setAge(user.getAge());

        return userRepository.save(u);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(findById(id));
    }

    @Override
    public User findById(int id) {
        User user = userRepository.findById(id);
        if(user == null)
            throw new UserServiceException("User with this id doesn't exist.");
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return (users != null) ? users : new ArrayList<>();
    }
}
