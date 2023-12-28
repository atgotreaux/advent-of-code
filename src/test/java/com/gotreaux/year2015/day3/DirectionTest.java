package com.gotreaux.year2015.day3;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {
    @Test
    void parseNorth() {
        assertEquals(Direction.NORTH, Direction.fromLabel('^'));
    }

    @Test
    void parseSouth() {
        assertEquals(Direction.SOUTH, Direction.fromLabel('v'));
    }

    @Test
    void parseEast() {
        assertEquals(Direction.EAST, Direction.fromLabel('>'));
    }

    @Test
    void parseWest() {
        assertEquals(Direction.WEST, Direction.fromLabel('<'));
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
}