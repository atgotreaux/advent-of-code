package com.gotreaux.aoc.puzzles.year2015.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Point;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionTest {
    @ParameterizedTest
    @MethodSource("provideParseDirection")
    void parseDirection(char label, Direction expectedDirection) {
        assertEquals(expectedDirection, Direction.fromLabel(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> Direction.fromLabel('x'));
    }

    @RepeatedTest(5)
    void moveNorth() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        assertEquals(new Point(point.x, point.y + 1), Direction.NORTH.move(point));
    }

    @RepeatedTest(5)
    void moveSouth() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        assertEquals(new Point(point.x, point.y - 1), Direction.SOUTH.move(point));
    }

    @RepeatedTest(5)
    void moveEast() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        assertEquals(new Point(point.x + 1, point.y), Direction.EAST.move(point));
    }

    @RepeatedTest(5)
    void moveWest() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        assertEquals(new Point(point.x - 1, point.y), Direction.WEST.move(point));
    }

    private static Stream<Arguments> provideParseDirection() {
        return Stream.of(
                Arguments.of('^', Direction.NORTH),
                Arguments.of('v', Direction.SOUTH),
                Arguments.of('>', Direction.EAST),
                Arguments.of('<', Direction.WEST));
    }
}
