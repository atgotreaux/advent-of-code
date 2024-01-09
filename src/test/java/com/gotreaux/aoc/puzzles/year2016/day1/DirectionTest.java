package com.gotreaux.aoc.puzzles.year2016.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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

    @Test
    void facingNorthTurnRight() {
        assertEquals(Direction.EAST, Direction.NORTH.turn(Instruction.RIGHT));
    }

    @Test
    void facingNorthTurnLeft() {
        assertEquals(Direction.WEST, Direction.NORTH.turn(Instruction.LEFT));
    }

    @Test
    void facingSouthTurnRight() {
        assertEquals(Direction.WEST, Direction.SOUTH.turn(Instruction.RIGHT));
    }

    @Test
    void facingSouthTurnLeft() {
        assertEquals(Direction.EAST, Direction.SOUTH.turn(Instruction.LEFT));
    }

    @Test
    void facingEastTurnRight() {
        assertEquals(Direction.SOUTH, Direction.EAST.turn(Instruction.RIGHT));
    }

    @Test
    void facingEastTurnLeft() {
        assertEquals(Direction.NORTH, Direction.EAST.turn(Instruction.LEFT));
    }

    @Test
    void facingWestTurnRight() {
        assertEquals(Direction.NORTH, Direction.WEST.turn(Instruction.RIGHT));
    }

    @Test
    void facingWestTurnLeft() {
        assertEquals(Direction.SOUTH, Direction.WEST.turn(Instruction.LEFT));
    }
}
