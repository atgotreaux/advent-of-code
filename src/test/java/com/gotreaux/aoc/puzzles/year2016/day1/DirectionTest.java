package com.gotreaux.aoc.puzzles.year2016.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        int units = generator.nextInt(1, 1000);

        assertEquals(new Point(point.x, point.y + units), Direction.NORTH.move(point, units));
    }

    @RepeatedTest(5)
    void moveSouth() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        int units = generator.nextInt(1, 1000);

        assertEquals(new Point(point.x, point.y - units), Direction.SOUTH.move(point, units));
    }

    @RepeatedTest(5)
    void moveEast() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        int units = generator.nextInt(1, 1000);

        assertEquals(new Point(point.x + units, point.y), Direction.EAST.move(point, units));
    }

    @RepeatedTest(5)
    void moveWest() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        int units = generator.nextInt(1, 1000);

        assertEquals(new Point(point.x - units, point.y), Direction.WEST.move(point, units));
    }

    @ParameterizedTest
    @MethodSource("provideFacingOnTurn")
    void facingOnTurn(Direction starting, Instruction instruction, Direction expected) {
        assertEquals(expected, starting.turn(instruction));
    }

    private static Stream<Arguments> provideFacingOnTurn() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Instruction.RIGHT, Direction.EAST),
                Arguments.of(Direction.NORTH, Instruction.LEFT, Direction.WEST),
                Arguments.of(Direction.SOUTH, Instruction.RIGHT, Direction.WEST),
                Arguments.of(Direction.SOUTH, Instruction.LEFT, Direction.EAST),
                Arguments.of(Direction.EAST, Instruction.RIGHT, Direction.SOUTH),
                Arguments.of(Direction.EAST, Instruction.LEFT, Direction.NORTH),
                Arguments.of(Direction.WEST, Instruction.RIGHT, Direction.NORTH),
                Arguments.of(Direction.WEST, Instruction.LEFT, Direction.SOUTH));
    }
}
