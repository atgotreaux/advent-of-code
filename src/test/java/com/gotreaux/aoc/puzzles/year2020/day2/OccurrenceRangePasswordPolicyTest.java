package com.gotreaux.aoc.puzzles.year2020.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OccurrenceRangePasswordPolicyTest {
    @Test
    void throwsIfNegativePolicyOccurrences() {
        RandomGenerator generator = RandomGenerator.getDefault();

        int negativeArgumentIndex = generator.nextInt(1, 3);
        int min =
                negativeArgumentIndex == 1L
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        int max =
                negativeArgumentIndex == 2L
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        assertThrows(
                IllegalArgumentException.class, () -> new OccurrencePasswordPolicy(min, max, 'x'));
    }

    @ParameterizedTest
    @MethodSource("providePasswordPasses")
    void passwordPasses(int min, int max, char target, String password, boolean expected) {
        OccurrencePasswordPolicy passwordPolicy = new OccurrencePasswordPolicy(min, max, target);

        assertEquals(expected, passwordPolicy.passes(password));
    }

    private static Stream<Arguments> providePasswordPasses() {
        return Stream.of(
                Arguments.of(1, 3, 'a', "abcde", true),
                Arguments.of(1, 3, 'b', "cdefg", false),
                Arguments.of(2, 9, 'c', "ccccccccc", true));
    }
}
