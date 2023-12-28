package com.gotreaux.year2015.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PresentTest {
    @Test
    void throwsIfNonPositiveDimension() {
        RandomGenerator generator = RandomGenerator.getDefault();
        long length = generator.nextLong();
        long width = generator.nextLong();
        long height = -generator.nextLong();

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
        return Stream.of(
                Arguments.of(2L, 3L, 4L, 52L),
                Arguments.of(1L, 1L, 10L, 42L)
        );
    }

    private static Stream<Arguments> provideAreaOfSmallestSide() {
        return Stream.of(
                Arguments.of(2L, 3L, 4L, 6L),
                Arguments.of(1L, 1L, 10L, 1L)
        );
    }

    private static Stream<Arguments> provideSmallestPerimeter() {
        return Stream.of(
                Arguments.of(2L, 3L, 4L, 10L),
                Arguments.of(1L, 1L, 10L, 4L)
        );
    }

    private static Stream<Arguments> provideVolume() {
        return Stream.of(
                Arguments.of(2L, 3L, 4L, 24L),
                Arguments.of(1L, 1L, 10L, 10L)
        );
    }
}