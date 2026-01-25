package com.gotreaux.aoc.utils.math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MathUtilsTest {

    @ParameterizedTest
    @MethodSource("provideLcm")
    void lcm(long x, long y, long expectedLcm) {
        assertEquals(expectedLcm, MathUtils.lcm(x, y));
    }

    @ParameterizedTest
    @MethodSource("provideGcd")
    void gcd(long x, long y, long expectedGcd) {
        assertEquals(expectedGcd, MathUtils.gcd(x, y));
    }

    @ParameterizedTest
    @MethodSource("provideConsecutiveSum")
    void consecutiveSum(int x, int expectedSum) {
        assertEquals(expectedSum, MathUtils.consecutiveSum(x));
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

    private static Stream<Arguments> provideConsecutiveSum() {
        return Stream.of(
                Arguments.of(11, 66),
                Arguments.of(4, 10),
                Arguments.of(3, 6),
                Arguments.of(5, 15),
                Arguments.of(9, 45));
    }
}
