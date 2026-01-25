package com.gotreaux.aoc.utils.cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;

class PointTest {

    @RepeatedTest(5)
    void translate() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var dx = generator.nextInt(-1000, 1000);
        var dy = generator.nextInt(-1000, 1000);

        assertEquals(new Point(point.x() + dx, point.y() + dy), point.translate(dx, dy));
    }

    @RepeatedTest(5)
    void moveUp() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x(), point.y() + units), point.move(RelativeDirection.UP, units));
    }

    @RepeatedTest(5)
    void moveDown() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x(), point.y() - units), point.move(RelativeDirection.DOWN, units));
    }

    @RepeatedTest(5)
    void moveLeft() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x() - units, point.y()), point.move(RelativeDirection.LEFT, units));
    }

    @RepeatedTest(5)
    void moveRight() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x() + units, point.y()),
                point.move(RelativeDirection.RIGHT, units));
    }

    @RepeatedTest(5)
    void moveNorth() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x(), point.y() + units),
                point.move(CardinalDirection.NORTH, units));
    }

    @RepeatedTest(5)
    void moveSouth() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x(), point.y() - units),
                point.move(CardinalDirection.SOUTH, units));
    }

    @RepeatedTest(5)
    void moveEast() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x() + units, point.y()), point.move(CardinalDirection.EAST, units));
    }

    @RepeatedTest(5)
    void moveWest() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x() - units, point.y()), point.move(CardinalDirection.WEST, units));
    }
}
