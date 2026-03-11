package com.bridgelabz.greeting_app.repository;

import com.bridgelabz.greeting_app.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}