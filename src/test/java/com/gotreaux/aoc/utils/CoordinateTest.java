package com.gotreaux.aoc.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;

class CoordinateTest {

    @RepeatedTest(5)
    void translate() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var dx = generator.nextInt(-1000, 1000);
        var dy = generator.nextInt(-1000, 1000);

        assertEquals(
                new Coordinate(coordinate.x() + dx, coordinate.y() + dy),
                coordinate.translate(dx, dy));
    }

    @RepeatedTest(5)
    void moveUp() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x(), coordinate.y() + units),
                coordinate.move(RelativeDirection.UP, units));
    }

    @RepeatedTest(5)
    void moveDown() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x(), coordinate.y() - units),
                coordinate.move(RelativeDirection.DOWN, units));
    }

    @RepeatedTest(5)
    void moveLeft() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x() - units, coordinate.y()),
                coordinate.move(RelativeDirection.LEFT, units));
    }

    @RepeatedTest(5)
    void moveRight() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x() + units, coordinate.y()),
                coordinate.move(RelativeDirection.RIGHT, units));
    }

    @RepeatedTest(5)
    void moveNorth() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x(), coordinate.y() + units),
                coordinate.move(CardinalDirection.NORTH, units));
    }

    @RepeatedTest(5)
    void moveSouth() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x(), coordinate.y() - units),
                coordinate.move(CardinalDirection.SOUTH, units));
    }

    @RepeatedTest(5)
    void moveEast() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x() + units, coordinate.y()),
                coordinate.move(CardinalDirection.EAST, units));
    }

    @RepeatedTest(5)
    void moveWest() {
        var generator = RandomGenerator.getDefault();

        var coordinate =
                new Coordinate(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Coordinate(coordinate.x() - units, coordinate.y()),
                coordinate.move(CardinalDirection.WEST, units));
    }
}
