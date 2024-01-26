package com.example.api.demoapi.controllers;

import com.example.api.demoapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ComponentScan
public class RegistrationController {

    private final RegistrationService registrationService;


    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public String registerUser(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        registrationService.registerUser(name, age, email);
       // new ResponseEntity<>("User registration successful", HttpStatus.OK);
        return "redirect:/";
    }

}

