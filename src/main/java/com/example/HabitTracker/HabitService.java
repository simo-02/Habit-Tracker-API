package com.example.HabitTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getHabit() {
        return habitRepository.findAll();
    }

    public void addNewHabit(Habit habit) {
        Optional<Habit> habitOptional = habitRepository.
                findHabitByName(habit.getName());
        if (habitOptional.isPresent()){
            throw new IllegalStateException("Habit with that name exists");
        }
        habitRepository.save(habit);
    }

    public void deleteHabit(String habitName) {
        Optional<Habit> habitOptional = habitRepository.findHabitByName(habitName);
        if (habitOptional.isEmpty()) {
            throw new IllegalStateException("Habit with name '" + habitName + "' does not exist");
        }
        habitRepository.delete(habitOptional.get());
    }


    public void updateHabit(Long id, String name) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "habit with id " + id + " does not exist"
                ));

        if (name != null && name.length() > 0 && !Objects.equals(habit.getName(), name)) {
            habit.setName(name);
            habitRepository.save(habit);
        }
    }

    public void trackHabitProgress(Long id, int tracking) {
        Habit habit = habitRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Habit with id " + id + " does not exist"));

        habit.setTracking(tracking);
        habitRepository.save(habit);
    }

}
