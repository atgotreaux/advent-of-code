package com.gotreaux.aoc.puzzles.year2015.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PresentTest {
    @Test
    void throwsIfNonPositiveDimension() {
        RandomGenerator generator = RandomGenerator.getDefault();
        long negativeArgumentIndex = generator.nextLong(1, 4);
        long length =
                negativeArgumentIndex == 1L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long width =
                negativeArgumentIndex == 2L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());
        long height =
                negativeArgumentIndex == 3L
                        ? -Math.abs(generator.nextLong())
                        : Math.abs(generator.nextLong());

        assertThrows(IllegalArgumentException.class, () -> new Present(length, width, height));
    }

    @ParameterizedTest
    @MethodSource("provideSurfaceArea")
    void surfaceArea(long length, long width, long height, long expectedSurfaceArea) {
        Present present = new Present(length, width, height);

        assertEquals(expectedSurfaceArea, present.getSurfaceArea());
    }

    @ParameterizedTest
    @MethodSource("provideAreaOfSmallestSide")
    void areaOfSmallestSide(long length, long width, long height, long expectedArea) {
        Present present = new Present(length, width, height);

        assertEquals(expectedArea, present.getAreaOfSmallestSide());
    }

    @ParameterizedTest
    @MethodSource("provideSmallestPerimeter")
    void smallestPerimeter(long length, long width, long height, long expectedPerimeter) {
        Present present = new Present(length, width, height);

        assertEquals(expectedPerimeter, present.getSmallestPerimeter());
    }

    @ParameterizedTest
    @MethodSource("provideVolume")
    void volume(long length, long width, long height, long expectedVolume) {
        Present present = new Present(length, width, height);

        assertEquals(expectedVolume, present.getVolume());
    }

    private static Stream<Arguments> provideSurfaceArea() {
        return Stream.of(Arguments.of(2L, 3L, 4L, 52L), Arguments.of(1L, 1L, 10L, 42L));
    }

    private static Stream<Arguments> provideAreaOfSmallestSide() {
        return Stream.of(Arguments.of(2L, 3L, 4L, 6L), Arguments.of(1L, 1L, 10L, 1L));
    }

    private static Stream<Arguments> provideSmallestPerimeter() {
        return Stream.of(Arguments.of(2L, 3L, 4L, 10L), Arguments.of(1L, 1L, 10L, 4L));
    }

    private static Stream<Arguments> provideVolume() {
        return Stream.of(Arguments.of(2L, 3L, 4L, 24L), Arguments.of(1L, 1L, 10L, 10L));
    }
}
