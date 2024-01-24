package com.gotreaux.aoc.puzzles.year2017.day3;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionTest {
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

    @ParameterizedTest
    @MethodSource("provideTurn")
    void turn(Direction facing, Direction expectedTurn) {
        assertEquals(expectedTurn, facing.turn());
    }

    private static Stream<Arguments> provideTurn() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.WEST),
                Arguments.of(Direction.SOUTH, Direction.EAST),
                Arguments.of(Direction.EAST, Direction.NORTH),
                Arguments.of(Direction.WEST, Direction.SOUTH));
    }
}
