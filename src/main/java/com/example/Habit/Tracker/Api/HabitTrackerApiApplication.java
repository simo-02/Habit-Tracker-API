package com.example.Habit.Tracker.Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class HabitTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitTrackerApiApplication.class, args);
	}

	@GetMapping
	public String hello(){
		return "Hello World";
	}
}
