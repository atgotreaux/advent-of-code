package com.gotreaux.year2019.day1;

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
        RandomGenerator generator = RandomGenerator.getDefault();
        long mass = -Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new Module(mass));
    }

    @ParameterizedTest
    @MethodSource("provideFuelRequirement")
    void fuelRequirement(long mass, long expectedFuelRequirement) {
        Module module = new Module(mass);

        assertEquals(expectedFuelRequirement, module.getFuelRequirement());
    }

    @ParameterizedTest
    @MethodSource("provideAdditionalFuelRequirement")
    void additionalFuelRequirement(long mass, long expectedFuelRequirement) {
        Module module = new Module(mass);

        assertEquals(expectedFuelRequirement, module.getAdditionalFuelRequirement());
    }

    private static Stream<Arguments> provideFuelRequirement() {
        return Stream.of(
                Arguments.of(12L, 2L),
                Arguments.of(14L, 2L),
                Arguments.of(1969L, 654L),
                Arguments.of(100756L, 33583L));
    }

    private static Stream<Arguments> provideAdditionalFuelRequirement() {
        return Stream.of(
                Arguments.of(12L, 2L),
                Arguments.of(14L, 2L),
                Arguments.of(1969L, 966L),
                Arguments.of(100756L, 50346L));
    }
}
