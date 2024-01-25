package com.example.api.demoapi.controllers;

import com.example.api.demoapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;


    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> registerUser(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        registrationService.registerUser(name, age, email);
        return new ResponseEntity<>("User registration successful", HttpStatus.OK);
    }
}

