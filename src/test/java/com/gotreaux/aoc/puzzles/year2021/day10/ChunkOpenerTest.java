package com.gotreaux.aoc.puzzles.year2021.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ChunkOpenerTest {
    @ParameterizedTest
    @MethodSource("provideParseChunkOpener")
    void parseChunkOpener(char label, ChunkOpener expectedChunkOpener) {
        assertEquals(expectedChunkOpener, ChunkOpener.of(label));
    }

    @Test
    void nullIfCannotParse() {
        assertNull(ChunkOpener.of('X'));
    }

    private static Stream<Arguments> provideParseChunkOpener() {
        return Stream.of(
                Arguments.of('(', ChunkOpener.PARENTHESIS),
                Arguments.of('[', ChunkOpener.SQUARE_BRACKET),
                Arguments.of('{', ChunkOpener.BRACE),
                Arguments.of('<', ChunkOpener.ANGLE_BRACKET));
    }
}
