package com.example.HabitTracker;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {
    public List<Habit> getHabit() {
        return List.of(
                new Habit(
                        1L,
                        "Workout",
                        "Leg day"
                )
        );
    }
}
