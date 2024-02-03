package com.gotreaux.aoc.utils;

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

class RelativeDirectionTest {
    @ParameterizedTest
    @MethodSource("provideParseInstruction")
    void parseInstruction(char label, RelativeDirection expectedInstruction) {
        assertEquals(expectedInstruction, RelativeDirection.fromLabel(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> RelativeDirection.fromLabel('X'));
    }

    @RepeatedTest(5)
    void moveUp() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        int units = generator.nextInt(1, 1000);

        assertEquals(new Point(point.x, point.y + units), RelativeDirection.UP.move(point, units));
    }

    @RepeatedTest(5)
    void moveDown() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        int units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x, point.y - units), RelativeDirection.DOWN.move(point, units));
    }

    @RepeatedTest(5)
    void moveLeft() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        int units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x - units, point.y), RelativeDirection.LEFT.move(point, units));
    }

    @RepeatedTest(5)
    void moveRight() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Point point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        int units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x + units, point.y), RelativeDirection.RIGHT.move(point, units));
    }

    private static Stream<Arguments> provideParseInstruction() {
        return Stream.of(
                Arguments.of('U', RelativeDirection.UP),
                Arguments.of('D', RelativeDirection.DOWN),
                Arguments.of('L', RelativeDirection.LEFT),
                Arguments.of('R', RelativeDirection.RIGHT));
    }
}
