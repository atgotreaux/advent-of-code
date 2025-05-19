package com.gotreaux.aoc.puzzles.year2018.day4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.HashMap;
import java.util.Map;

class Guard {

    private final int id;
    private final Map<Integer, Integer> sleepMapping = new HashMap<>();

    Guard(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }

    void addSleep(LocalDateTime start, ChronoLocalDateTime<LocalDate> end) {
        var time = start;
        while (!time.isEqual(end)) {
            sleepMapping.merge(time.getMinute(), 1, Integer::sum);
            time = time.plusMinutes(1);
        }
    }

    int getTotalMinutesAsleep() {
        return sleepMapping.values().stream().mapToInt(Integer::intValue).sum();
    }

    int getMinuteMostAsleep() {
        return sleepMapping.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    int getHighestMinuteFrequency() {
        return sleepMapping.values().stream().max(Integer::compareTo).orElse(0);
    }
}
