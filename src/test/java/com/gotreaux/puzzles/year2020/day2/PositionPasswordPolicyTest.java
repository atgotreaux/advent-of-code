package com.gotreaux.puzzles.year2020.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositionPasswordPolicyTest {
    @Test
    void throwsIfNegativePolicyPositions() {
        RandomGenerator generator = RandomGenerator.getDefault();

        long negativeArgumentIndex = generator.nextLong(1, 3);
        long first =
                negativeArgumentIndex == 1L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long second =
                negativeArgumentIndex == 2L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(
                IllegalArgumentException.class,
                () -> new PositionPasswordPolicy(first, second, 'x'));
    }

    @ParameterizedTest
    @MethodSource("providePasswordPasses")
    void passwordPasses(long first, long second, char target, String password, boolean expected) {
        PositionPasswordPolicy passwordPolicy = new PositionPasswordPolicy(first, second, target);

        assertEquals(expected, passwordPolicy.passes(password));
    }

    private static Stream<Arguments> providePasswordPasses() {
        return Stream.of(
                Arguments.of(1L, 3L, 'a', "abcde", true),
                Arguments.of(1L, 3L, 'b', "cdefg", false),
                Arguments.of(2L, 9L, 'c', "ccccccccc", false));
    }
}
