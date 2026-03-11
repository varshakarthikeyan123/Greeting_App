package com.bridgelabz.controller;

import com.bridgelabz.greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public String getGreeting() {
        return greetingService.getGreetingMessage();
    }
}