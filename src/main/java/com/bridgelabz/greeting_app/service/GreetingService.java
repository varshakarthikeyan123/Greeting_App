package com.bridgelabz.greeting_app.service;

import com.bridgelabz.greeting_app.entity.Greeting;
import com.bridgelabz.greeting_app.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    public Greeting updateGreeting(Long id, String message) {

        Greeting greeting = greetingRepository.findById(id).orElse(null);

        if (greeting != null) {
            greeting.setMessage(message);
            return greetingRepository.save(greeting);
        }

        return null;
    }
    public String deleteGreeting(Long id) {

        greetingRepository.deleteById(id);

        return "Greeting with id " + id + " deleted successfully";
    }
}
