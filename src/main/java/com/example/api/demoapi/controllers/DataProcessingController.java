package com.example.api.demoapi.controllers;

import com.example.api.demoapi.models.User;
import com.example.api.demoapi.service.DataProcessingService;
import com.example.api.demoapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;
    private final RegistrationService registrationService;

    @Autowired
    public DataProcessingController(DataProcessingService helloService, RegistrationService registrationService) {
        this.dataProcessingService = helloService;
        this.registrationService = registrationService;
    }


    @PostMapping("/sort")
    public String sortUsers(Model model) {
        List<User> list = dataProcessingService.sortUsersByAge(registrationService.getUserList());
        model.addAttribute("users", list);
        return "index";
    }

    @PostMapping("/filter")
    public String filterUsersByAge(@RequestParam (defaultValue = "0") Integer age, Model model) {
        List<User> list = dataProcessingService.filterUsersByAge(registrationService.getUserList(), age);
        model.addAttribute("users", list);
        return "index";
    }

    @GetMapping("/average")
    public String average(Model model) {
        Double age = dataProcessingService.calculateAverageAge(registrationService.getUserList());
        model.addAttribute("calcAge", age);
        model.addAttribute("users", registrationService.getUserList());
        return "index";
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("users", registrationService.getUserList());
        return "index";
    }


}
