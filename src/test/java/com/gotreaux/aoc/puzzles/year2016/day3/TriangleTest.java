package com.gotreaux.aoc.puzzles.year2016.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TriangleTest {
    @Test
    void throwsIfNegativeSideLength() {
        RandomGenerator generator = RandomGenerator.getDefault();

        int negativeArgumentIndex = generator.nextInt(1, 4);
        int a =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        int b =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        int c =
                negativeArgumentIndex == 3
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        assertThrows(IllegalArgumentException.class, () -> new Triangle(a, b, c));
    }

    @ParameterizedTest
    @MethodSource("provideValidTriangle")
    void validTriangle(int a, int b, int c, boolean isValid) {
        Triangle triangle = new Triangle(a, b, c);

        assertEquals(isValid, triangle.isValid());
    }

    private static Stream<Arguments> provideValidTriangle() {
        return Stream.of(
                Arguments.of(5, 10, 25, false),
                Arguments.of(101, 102, 103, true),
                Arguments.of(201, 202, 203, true),
                Arguments.of(301, 302, 303, true),
                Arguments.of(401, 402, 403, true),
                Arguments.of(501, 502, 503, true),
                Arguments.of(601, 602, 603, true));
    }
}
