package com.bridgelabz.controller;

import com.bridgelabz.greeting_app.entity.Greeting;
import com.bridgelabz.greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @PostMapping("/greeting")
    public Greeting createGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        return greetingService.saveGreeting(firstName, lastName);
    }
}