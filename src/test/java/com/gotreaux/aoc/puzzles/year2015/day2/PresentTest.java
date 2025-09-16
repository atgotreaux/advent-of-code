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

    @ParameterizedTest
    @MethodSource("provideOf")
    void of(String line, int expectedLength, int expectedWidth, int expectedHeight) {
        var present = Present.of(line);

        assertEquals(expectedLength, present.length());
        assertEquals(expectedWidth, present.width());
        assertEquals(expectedHeight, present.height());
    }

    @Test
    void throwsIfIncorrectPartLength() {
        assertThrows(IllegalArgumentException.class, () -> Present.of("2x3x4x5"));
    }

    @Test
    void throwsIfNonPositiveDimension() {
        var generator = RandomGenerator.getDefault();
        var negativeArgumentIndex = generator.nextInt(1, 4);
        var length =
                negativeArgumentIndex == 1
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        var width =
                negativeArgumentIndex == 2
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());
        var height =
                negativeArgumentIndex == 3
                        ? -Math.abs(generator.nextInt())
                        : Math.abs(generator.nextInt());

        assertThrows(IllegalArgumentException.class, () -> new Present(length, width, height));
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(Arguments.of("2x3x4", 2, 3, 4), Arguments.of("1x1x10", 1, 1, 10));
    }

    @ParameterizedTest
    @MethodSource("provideSurfaceArea")
    void surfaceArea(int length, int width, int height, int expectedSurfaceArea) {
        var present = new Present(length, width, height);

        assertEquals(expectedSurfaceArea, present.getSurfaceArea());
    }

    @ParameterizedTest
    @MethodSource("provideAreaOfSmallestSide")
    void areaOfSmallestSide(int length, int width, int height, int expectedArea) {
        var present = new Present(length, width, height);

        assertEquals(expectedArea, present.getAreaOfSmallestSide());
    }

    @ParameterizedTest
    @MethodSource("provideSmallestPerimeter")
    void smallestPerimeter(int length, int width, int height, int expectedPerimeter) {
        var present = new Present(length, width, height);

        assertEquals(expectedPerimeter, present.getSmallestPerimeter());
    }

    @ParameterizedTest
    @MethodSource("provideVolume")
    void volume(int length, int width, int height, int expectedVolume) {
        var present = new Present(length, width, height);

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
