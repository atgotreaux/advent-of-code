package com.gotreaux.aoc.puzzles.year2019.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ModuleTest {
    @Test
    void throwsIfMassIsNonPositive() {
        var generator = RandomGenerator.getDefault();
        var mass = -Math.abs(generator.nextInt());

        assertThrows(IllegalArgumentException.class, () -> new Module(mass));
    }

    @ParameterizedTest
    @MethodSource("provideFuelRequirement")
    void fuelRequirement(int mass, int expectedFuelRequirement) {
        var module = new Module(mass);

        assertEquals(expectedFuelRequirement, module.getFuelRequirement());
    }

    @ParameterizedTest
    @MethodSource("provideAdditionalFuelRequirement")
    void additionalFuelRequirement(int mass, int expectedFuelRequirement) {
        var module = new Module(mass);

        assertEquals(expectedFuelRequirement, module.getAdditionalFuelRequirement());
    }

    private static Stream<Arguments> provideFuelRequirement() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(14, 2),
                Arguments.of(1969, 654),
                Arguments.of(100756, 33583));
    }

    private static Stream<Arguments> provideAdditionalFuelRequirement() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(14, 2),
                Arguments.of(1969, 966),
                Arguments.of(100756, 50346));
    }
}
