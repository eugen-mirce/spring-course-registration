package com.lhind.course.controller.rest;

import com.lhind.course.model.entity.User;
import com.lhind.course.model.response.UserRest;
import com.lhind.course.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserRest> getAll() {
        List<User> users = userService.findAll();
        List<UserRest> returnValue = new ArrayList<>();

        for(User user : users) {
            UserRest userRest = new UserRest();
            BeanUtils.copyProperties(user,userRest);
            returnValue.add(userRest);
        }
        return returnValue;
    }
    @GetMapping(path = "{userId}")
    public UserRest getUser(@PathVariable int userId) {
        User user = userService.findById(userId);
        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(user, returnValue);
        return returnValue;
    }

    @PostMapping
    public UserRest createUser(@RequestBody User user) {
        user = userService.createUser(user);
        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(user,returnValue);
        return returnValue;
    }

    @DeleteMapping(path = "{userId}")
    public String deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return "SUCCESS";
    }

    @PutMapping(path = "{userId}")
    public UserRest updateUser(@PathVariable int userId, @RequestBody User user) {
        user.setId(userId);
        user = userService.updateUser(user);
        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(user,returnValue);
        return returnValue;
    }
}
