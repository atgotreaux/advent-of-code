package com.gotreaux.aoc.puzzles.year2018.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.lang.Nullable;

class GuardRecordTest {

    @ParameterizedTest
    @MethodSource("provideFrom")
    void from(
            String line,
            LocalDateTime expectedDateTime,
            Status expectedStatus,
            @Nullable Integer expectedGuardId) {
        GuardRecord record = GuardRecord.from(line);

        assertEquals(expectedDateTime, record.time());
        assertEquals(expectedStatus, record.status());
        assertEquals(expectedGuardId, record.guardId());
    }

    @Test
    void throwsIfInvalidRecord() {
        assertThrows(IllegalArgumentException.class, () -> GuardRecord.from("x"));
    }

    private static Stream<Arguments> provideFrom() {
        return Stream.of(
                Arguments.of(
                        "[1518-11-01 00:00] Guard #10 begins shift",
                        LocalDateTime.of(1518, 11, 1, 0, 0),
                        Status.BEGINS_SHIFT,
                        10),
                Arguments.of(
                        "[1518-11-01 00:05] falls asleep",
                        LocalDateTime.of(1518, 11, 1, 0, 5),
                        Status.FALLS_ASLEEP,
                        null),
                Arguments.of(
                        "[1518-11-01 00:25] wakes up",
                        LocalDateTime.of(1518, 11, 1, 0, 25),
                        Status.WAKES_UP,
                        null));
    }
}
