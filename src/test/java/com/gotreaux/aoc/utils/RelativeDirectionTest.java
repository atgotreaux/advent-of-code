package com.gotreaux.aoc.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.stream.Stream;
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

    private static Stream<Arguments> provideParseInstruction() {
        return Stream.of(
                Arguments.of('U', RelativeDirection.UP),
                Arguments.of('D', RelativeDirection.DOWN),
                Arguments.of('L', RelativeDirection.LEFT),
                Arguments.of('R', RelativeDirection.RIGHT));
    }
}
