package com.example.api.demoapi.service;

import com.example.api.demoapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class RegistrationService {

    private List<User> userList = new ArrayList<>();;
    private final UserService userService;
    private final NotificationService notificationService;

    @Autowired
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public void registerUser(String name, int age, String email) {
        User newUser = userService.createUser(name, age, email);
        userList.add(newUser);
        notificationService.notifyUser(newUser);
        System.out.println("User list after sorting and filtering: " + userList);
    }

    public List<User> getUserList() {
        return userList;
    }
}