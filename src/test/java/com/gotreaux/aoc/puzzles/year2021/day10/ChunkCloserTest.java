package com.gotreaux.aoc.puzzles.year2021.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ChunkCloserTest {
    @ParameterizedTest
    @MethodSource("provideParseChunkCloser")
    void parseChunkCloser(char label, ChunkCloser expectedChunkCloser) {
        assertEquals(expectedChunkCloser, ChunkCloser.of(label));
    }

    @Test
    void nullIfCannotParse() {
        assertNull(ChunkCloser.of('X'));
    }

    private static Stream<Arguments> provideParseChunkCloser() {
        return Stream.of(
                Arguments.of(')', ChunkCloser.PARENTHESIS),
                Arguments.of(']', ChunkCloser.SQUARE_BRACKET),
                Arguments.of('}', ChunkCloser.BRACE),
                Arguments.of('>', ChunkCloser.ANGLE_BRACKET));
    }
}
