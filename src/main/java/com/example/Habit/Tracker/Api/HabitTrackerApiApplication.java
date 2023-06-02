package com.example.Habit.Tracker.Api;

import com.example.HabitTracker.Habit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class HabitTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HabitTrackerApiApplication.class, args);
	}

	@GetMapping
	public List<Habit> hello(){
		return List.of(
				new Habit(
						1L,
						"Workout",
						"Leg day"
				)
		);

	}
}
