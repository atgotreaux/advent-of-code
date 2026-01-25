package com.gotreaux.aoc.utils.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CellTest {

    @ParameterizedTest
    @MethodSource("provideMove")
    void move(Cell cell, Direction direction, Cell expected) {
        assertEquals(expected, cell.move(direction));
    }

    private static Stream<Arguments> provideMove() {
        return Stream.of(
                Arguments.of(new Cell(5, 5), Direction.NORTH, new Cell(4, 5)),
                Arguments.of(new Cell(5, 5), Direction.SOUTH, new Cell(6, 5)),
                Arguments.of(new Cell(5, 5), Direction.EAST, new Cell(5, 6)),
                Arguments.of(new Cell(5, 5), Direction.WEST, new Cell(5, 4)),
                Arguments.of(new Cell(5, 5), Direction.NORTHEAST, new Cell(4, 6)),
                Arguments.of(new Cell(5, 5), Direction.NORTHWEST, new Cell(4, 4)),
                Arguments.of(new Cell(5, 5), Direction.SOUTHEAST, new Cell(6, 6)),
                Arguments.of(new Cell(5, 5), Direction.SOUTHWEST, new Cell(6, 4)),
                Arguments.of(new Cell(0, 0), Direction.NORTH, new Cell(-1, 0)),
                Arguments.of(new Cell(0, 0), Direction.WEST, new Cell(0, -1)),
                Arguments.of(new Cell(10, 10), Direction.SOUTH, new Cell(11, 10)),
                Arguments.of(new Cell(10, 10), Direction.EAST, new Cell(10, 11)));
    }
}
