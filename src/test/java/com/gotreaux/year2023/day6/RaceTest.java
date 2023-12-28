package com.gotreaux.year2023.day6;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RaceTest {
    @Test
    void throwsIfNonPositiveRace() {
        RandomGenerator generator = RandomGenerator.getDefault();
        long time = generator.nextLong();
        long recordDistance = -generator.nextLong();

        assertThrows(IllegalArgumentException.class, () -> new Race(time, recordDistance));
    }
}