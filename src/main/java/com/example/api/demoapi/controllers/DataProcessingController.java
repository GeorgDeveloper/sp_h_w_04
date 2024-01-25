package com.example.api.demoapi.controllers;

import com.example.api.demoapi.models.User;
import com.example.api.demoapi.service.DataProcessingService;
import com.example.api.demoapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;
    private final RegistrationService registrationService;

    @Autowired
    public DataProcessingController(DataProcessingService helloService, RegistrationService registrationService) {
        this.dataProcessingService = helloService;
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        String responce = this.dataProcessingService.getGreeting();

        return new ResponseEntity<>(responce, HttpStatus.OK);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.GET)
    public ResponseEntity<List<User>> sortUsers() {

        return new ResponseEntity<>(dataProcessingService.sortUsersByAge(registrationService.getUserList()), HttpStatus.OK);
    }

    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterUsersByAge(@PathVariable("age") Integer age) {
        return new ResponseEntity<>(dataProcessingService.filterUsersByAge(registrationService.getUserList(), age), HttpStatus.OK);
    }

    @RequestMapping(value = "/average", method = RequestMethod.GET)
    public ResponseEntity<Double> average() {
        return new ResponseEntity<>(dataProcessingService.calculateAverageAge(registrationService.getUserList()), HttpStatus.OK);
    }
}
