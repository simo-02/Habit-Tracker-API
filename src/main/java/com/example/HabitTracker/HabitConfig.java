package com.example.HabitTracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HabitConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            HabitRepository repository){
        return args -> {
            Habit habit1 = new Habit(
                    "Workout",
                    "Leg day"
            );

            Habit habit2 = new Habit(
                    "Grocery Shopping",
                    "."
            );

            repository.saveAll(
                    List.of(habit1, habit2)
            );
        };
    }
}
