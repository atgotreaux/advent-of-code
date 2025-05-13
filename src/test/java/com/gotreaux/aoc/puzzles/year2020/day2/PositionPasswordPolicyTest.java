package com.gotreaux.aoc.puzzles.year2020.day2;

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
        var generator = RandomGenerator.getDefault();

        var negativeArgumentIndex = generator.nextInt(1, 3);
        var first =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        var second =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        assertThrows(
                IllegalArgumentException.class,
                () -> new PositionPasswordPolicy(first, second, 'x'));
    }

    @ParameterizedTest
    @MethodSource("providePasswordPasses")
    void passwordPasses(int first, int second, char target, String password, boolean expected) {
        var passwordPolicy = new PositionPasswordPolicy(first, second, target);

        assertEquals(expected, passwordPolicy.passes(password));
    }

    private static Stream<Arguments> providePasswordPasses() {
        return Stream.of(
                Arguments.of(1, 3, 'a', "abcde", true),
                Arguments.of(1, 3, 'b', "cdefg", false),
                Arguments.of(2, 9, 'c', "ccccccccc", false));
    }
}
