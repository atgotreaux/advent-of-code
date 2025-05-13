package com.gotreaux.aoc.puzzles.year2018.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GuardTest {

    @ParameterizedTest
    @MethodSource("provideGetTotalMinutesAsleep")
    void getTotalMinutesAsleep(
            Guard guard,
            List<LocalDateTime> startTimes,
            List<LocalDateTime> endTimes,
            int expected) {
        for (var i = 0; i < startTimes.size(); i++) {
            guard.addSleep(startTimes.get(i), endTimes.get(i));
        }

        assertEquals(expected, guard.getTotalMinutesAsleep());
    }

    @ParameterizedTest
    @MethodSource("provideGetMinuteMostAsleep")
    void getMinuteMostAsleep(
            Guard guard,
            List<LocalDateTime> startTimes,
            List<LocalDateTime> endTimes,
            int expected) {
        for (var i = 0; i < startTimes.size(); i++) {
            guard.addSleep(startTimes.get(i), endTimes.get(i));
        }

        assertEquals(expected, guard.getMinuteMostAsleep());
    }

    @Test
    void minuteMostAsleepThrowsIfNoSleep() {
        var guard = new Guard(10);

        assertThrows(NoSuchElementException.class, guard::getMinuteMostAsleep);
    }

    @ParameterizedTest
    @MethodSource("provideGetHighestMinuteFrequency")
    void getHighestMinuteFrequency(
            Guard guard,
            List<LocalDateTime> startTimes,
            List<LocalDateTime> endTimes,
            int expected) {
        for (var i = 0; i < startTimes.size(); i++) {
            guard.addSleep(startTimes.get(i), endTimes.get(i));
        }

        assertEquals(expected, guard.getHighestMinuteFrequency());
    }

    private static Stream<Arguments> provideGetTotalMinutesAsleep() {
        return Stream.of(
                Arguments.of(
                        new Guard(10),
                        List.of(
                                LocalDateTime.of(1518, 11, 1, 0, 5),
                                LocalDateTime.of(1518, 11, 1, 0, 30),
                                LocalDateTime.of(1518, 11, 3, 0, 24)),
                        List.of(
                                LocalDateTime.of(1518, 11, 1, 0, 25),
                                LocalDateTime.of(1518, 11, 1, 0, 55),
                                LocalDateTime.of(1518, 11, 3, 0, 29)),
                        50),
                Arguments.of(
                        new Guard(99),
                        List.of(
                                LocalDateTime.of(1518, 11, 2, 0, 40),
                                LocalDateTime.of(1518, 11, 4, 0, 36),
                                LocalDateTime.of(1518, 11, 5, 0, 45)),
                        List.of(
                                LocalDateTime.of(1518, 11, 2, 0, 50),
                                LocalDateTime.of(1518, 11, 4, 0, 46),
                                LocalDateTime.of(1518, 11, 5, 0, 55)),
                        30));
    }

    private static Stream<Arguments> provideGetMinuteMostAsleep() {
        return Stream.of(
                Arguments.of(
                        new Guard(10),
                        List.of(
                                LocalDateTime.of(1518, 11, 1, 0, 5),
                                LocalDateTime.of(1518, 11, 1, 0, 30),
                                LocalDateTime.of(1518, 11, 3, 0, 24)),
                        List.of(
                                LocalDateTime.of(1518, 11, 1, 0, 25),
                                LocalDateTime.of(1518, 11, 1, 0, 55),
                                LocalDateTime.of(1518, 11, 3, 0, 29)),
                        24));
    }

    private static Stream<Arguments> provideGetHighestMinuteFrequency() {
        return Stream.of(
                Arguments.of(new Guard(10), List.of(), List.of(), 0),
                Arguments.of(
                        new Guard(99),
                        List.of(
                                LocalDateTime.of(1518, 11, 2, 0, 40),
                                LocalDateTime.of(1518, 11, 4, 0, 36),
                                LocalDateTime.of(1518, 11, 5, 0, 45)),
                        List.of(
                                LocalDateTime.of(1518, 11, 2, 0, 50),
                                LocalDateTime.of(1518, 11, 4, 0, 46),
                                LocalDateTime.of(1518, 11, 5, 0, 55)),
                        3));
    }
}
