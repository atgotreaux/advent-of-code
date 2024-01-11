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
        int negativeArgumentIndex = generator.nextInt(1, 4);
        int length =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        int width =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        int height =
                negativeArgumentIndex == 3
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        assertThrows(IllegalArgumentException.class, () -> new Present(length, width, height));
    }

    @ParameterizedTest
    @MethodSource("provideSurfaceArea")
    void surfaceArea(int length, int width, int height, int expectedSurfaceArea) {
        Present present = new Present(length, width, height);

        assertEquals(expectedSurfaceArea, present.getSurfaceArea());
    }

    @ParameterizedTest
    @MethodSource("provideAreaOfSmallestSide")
    void areaOfSmallestSide(int length, int width, int height, int expectedArea) {
        Present present = new Present(length, width, height);

        assertEquals(expectedArea, present.getAreaOfSmallestSide());
    }

    @ParameterizedTest
    @MethodSource("provideSmallestPerimeter")
    void smallestPerimeter(int length, int width, int height, int expectedPerimeter) {
        Present present = new Present(length, width, height);

        assertEquals(expectedPerimeter, present.getSmallestPerimeter());
    }

    @ParameterizedTest
    @MethodSource("provideVolume")
    void volume(int length, int width, int height, int expectedVolume) {
        Present present = new Present(length, width, height);

        assertEquals(expectedVolume, present.getVolume());
    }

    private static Stream<Arguments> provideSurfaceArea() {
        return Stream.of(Arguments.of(2, 3, 4, 52), Arguments.of(1, 1, 10, 42));
    }

    private static Stream<Arguments> provideAreaOfSmallestSide() {
        return Stream.of(Arguments.of(2, 3, 4, 6), Arguments.of(1, 1, 10, 1));
    }

    private static Stream<Arguments> provideSmallestPerimeter() {
        return Stream.of(Arguments.of(2, 3, 4, 10), Arguments.of(1, 1, 10, 4));
    }

    private static Stream<Arguments> provideVolume() {
        return Stream.of(Arguments.of(2, 3, 4, 24), Arguments.of(1, 1, 10, 10));
    }
}
