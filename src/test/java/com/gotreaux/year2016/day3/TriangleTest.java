package com.gotreaux.year2016.day3;

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

        long negativeArgumentIndex = generator.nextLong(1, 4);
        long a =
                negativeArgumentIndex == 1L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long b =
                negativeArgumentIndex == 2L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long c =
                negativeArgumentIndex == 3L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new Triangle(a, b, c));
    }

    @ParameterizedTest
    @MethodSource("provideValidTriangle")
    void validTriangle(long a, long b, long c, boolean isValid) {
        Triangle triangle = new Triangle(a, b, c);

        assertEquals(isValid, triangle.isValid());
    }

    private static Stream<Arguments> provideValidTriangle() {
        return Stream.of(
                Arguments.of(5L, 10L, 25L, false),
                Arguments.of(101L, 102L, 103L, true),
                Arguments.of(201L, 202L, 203L, true),
                Arguments.of(301L, 302L, 303L, true),
                Arguments.of(401L, 402L, 403L, true),
                Arguments.of(501L, 502L, 503L, true),
                Arguments.of(601L, 602L, 603L, true));
    }
}
