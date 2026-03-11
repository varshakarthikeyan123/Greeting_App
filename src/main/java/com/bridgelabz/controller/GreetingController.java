package com.bridgelabz.controller;

import com.bridgelabz.greeting_app.entity.Greeting;
import com.bridgelabz.greeting_app.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // UC4 – Create Greeting
    @PostMapping("/greeting")
    public Greeting createGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {

        return greetingService.saveGreeting(firstName, lastName);
    }

    // UC5 – Get Greeting by ID
    @GetMapping("/greeting/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    // UC6 – Get All Greetings
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    @PutMapping("/greeting/{id}")
    public Greeting updateGreeting(
            @PathVariable Long id,
            @RequestParam String message) {

        return greetingService.updateGreeting(id, message);
    }
}
