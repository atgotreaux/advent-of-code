package com.gotreaux.aoc.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MathUtilsTest {

    @ParameterizedTest
    @MethodSource("provideLcm")
    void lcm(long a, long b, long expectedLcm) {
        assertEquals(expectedLcm, MathUtils.lcm(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideGcd")
    void gcd(long a, long b, long expectedGcd) {
        assertEquals(expectedGcd, MathUtils.gcd(a, b));
    }

    private static Stream<Arguments> provideLcm() {
        return Stream.of(
                Arguments.of(4L, 6L, 12L),
                Arguments.of(6L, 8L, 24L),
                Arguments.of(12L, 16L, 48L),
                Arguments.of(12L, 9L, 36L));
    }

    private static Stream<Arguments> provideGcd() {
        return Stream.of(
                Arguments.of(18L, 27L, 9L),
                Arguments.of(30L, 42L, 6L),
                Arguments.of(60L, 90L, 30L),
                Arguments.of(198L, 360L, 18L));
    }
}
