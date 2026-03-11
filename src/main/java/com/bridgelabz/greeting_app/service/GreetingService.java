package com.bridgelabz.greeting_app.service;

import com.bridgelabz.greeting_app.entity.Greeting;
import com.bridgelabz.greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting saveGreeting(String firstName, String lastName) {

        String message;

        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName;
        }
        else if (firstName != null) {
            message = "Hello " + firstName;
        }
        else if (lastName != null) {
            message = "Hello " + lastName;
        }
        else {
            message = "Hello World";
        }

        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }
}

