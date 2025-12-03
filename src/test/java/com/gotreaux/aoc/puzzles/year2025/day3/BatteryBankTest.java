package com.gotreaux.aoc.puzzles.year2025.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BatteryBankTest {

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(CharSequence line, BatteryBank expectedBatteryBank) {
        assertEquals(expectedBatteryBank, BatteryBank.of(line));
    }

    @Test
    void throwsIfContainsNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> BatteryBank.of("98765432a1111111"));
    }

    @Test
    void throwsIfContainsLessThanTwoDigits() {
        assertThrows(IllegalArgumentException.class, () -> BatteryBank.of("1"));
    }

    @ParameterizedTest
    @MethodSource("provideGetMaximumOutputJoltage")
    void getMaximumOutputJoltage(
            BatteryBank batteryBank, int batteryCount, int expectedMaxOutputJoltage) {
        assertEquals(expectedMaxOutputJoltage, batteryBank.getMaximumOutputJoltage(batteryCount));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of(
                        "987654321111111",
                        new BatteryBank(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1))),
                Arguments.of(
                        "811111111111119",
                        new BatteryBank(List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9))),
                Arguments.of(
                        "234234234234278",
                        new BatteryBank(List.of(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8))),
                Arguments.of(
                        "818181911112111",
                        new BatteryBank(List.of(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1))));
    }

    private static Stream<Arguments> provideGetMaximumOutputJoltage() {
        return Stream.of(
                Arguments.of(
                        new BatteryBank(List.of(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1)),
                        2,
                        98),
                Arguments.of(
                        new BatteryBank(List.of(8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)),
                        2,
                        89),
                Arguments.of(
                        new BatteryBank(List.of(2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 3, 4, 2, 7, 8)),
                        2,
                        78),
                Arguments.of(
                        new BatteryBank(List.of(8, 1, 8, 1, 8, 1, 9, 1, 1, 1, 1, 2, 1, 1, 1)),
                        2,
                        92));
    }
}
