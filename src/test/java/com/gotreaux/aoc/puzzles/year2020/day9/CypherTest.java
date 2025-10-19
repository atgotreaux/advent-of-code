package com.gotreaux.aoc.puzzles.year2020.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

class CypherTest {

    @Test
    void throwsIfPreambleLengthViolation() {
        assertThrows(IllegalArgumentException.class, () -> new Cypher(List.of(1L, 2L, 3L), 1));
    }

    @Test
    void throwsIfInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> new Cypher(List.of(1L, 2L, 3L, 4L), 4));
    }

    @Test
    void findInvalidNumber() {
        InputReader inputReader = new ResourceInputReader<>(EncodingErrorPuzzle.class);

        var numbers = inputReader.getInputList().stream().map(Long::valueOf).toList();

        var history = new Cypher(numbers, 5);

        assertEquals(127L, history.findInvalidNumber());
    }

    @Test
    void findContiguousSetSummingTo() {
        InputReader inputReader = new ResourceInputReader<>(EncodingErrorPuzzle.class);

        var numbers = inputReader.getInputList().stream().map(Long::valueOf).toList();

        var history = new Cypher(numbers, 5);

        assertEquals(62L, history.findContiguousSetSummingTo(127L));
    }
}
