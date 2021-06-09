package com.lhind.course.service.impl;

import com.lhind.course.model.User;
import com.lhind.course.repository.UserRepository;
import com.lhind.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //TODO Add exception if doesn't exist
        userRepository.delete(findById(id));
    }

    @Override
    public User findById(int id) {
        //TODO Add exception if doesn't exist
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
