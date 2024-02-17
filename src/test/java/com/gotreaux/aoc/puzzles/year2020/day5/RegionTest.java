package com.gotreaux.aoc.puzzles.year2020.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RegionTest {
    @ParameterizedTest
    @MethodSource("provideParseRegion")
    void parseRegion(char label, Region expectedRegion) {
        assertEquals(expectedRegion, Region.fromLabel(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Region.fromLabel('X'));
    }

    private static Stream<Arguments> provideParseRegion() {
        return Stream.of(
                Arguments.of('F', Region.FRONT),
                Arguments.of('B', Region.BACK),
                Arguments.of('L', Region.LEFT),
                Arguments.of('R', Region.RIGHT));
    }
}
