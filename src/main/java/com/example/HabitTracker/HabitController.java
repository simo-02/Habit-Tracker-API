package com.example.HabitTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/habit")
public class HabitController {

    private final HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<Habit> getHabit() {
        return habitService.getHabit();
    }

    @PostMapping
    public void registerNewHabit(@RequestBody Habit habit) {
        habitService.addNewHabit(habit);
    }

    @DeleteMapping(path = "{habitName}")
    public void deleteHabit(
            @PathVariable("habitName") String habitName){
        habitService.deleteHabit(habitName);
    }

    @PutMapping(path = "{id}")
    public void updateHabit(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name) {
        habitService.updateHabit(id, name);
    }

    @PostMapping(path = "{id}/track")
    public void trackHabitProgress(@PathVariable("id") Long id, @RequestBody ProgressDto progressDto) {
        habitService.trackHabitProgress(id, progressDto.getTracking());
    }



}
