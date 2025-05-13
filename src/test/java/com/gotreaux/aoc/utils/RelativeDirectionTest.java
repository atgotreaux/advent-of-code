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
        assertEquals(expectedInstruction, RelativeDirection.of(label));
    }

    @Test
    void throwsIfCannotParse() {
        assertThrows(NoSuchElementException.class, () -> RelativeDirection.of('X'));
    }

    @RepeatedTest(5)
    void moveUp() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(new Point(point.x, point.y + units), RelativeDirection.UP.move(point, units));
    }

    @RepeatedTest(5)
    void moveDown() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x, point.y - units), RelativeDirection.DOWN.move(point, units));
    }

    @RepeatedTest(5)
    void moveLeft() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

        assertEquals(
                new Point(point.x - units, point.y), RelativeDirection.LEFT.move(point, units));
    }

    @RepeatedTest(5)
    void moveRight() {
        var generator = RandomGenerator.getDefault();

        var point = new Point(generator.nextInt(-1000, 1000), generator.nextInt(-1000, 1000));

        var units = generator.nextInt(1, 1000);

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
