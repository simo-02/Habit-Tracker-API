package com.example.HabitTracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/habit ")
public class HabitController {

    @GetMapping
    public List<Habit> getHabit(){
        return List.of(
                new Habit(
                        1L,
                        "Workout",
                        "Leg day"
                )
        );

    }
}

