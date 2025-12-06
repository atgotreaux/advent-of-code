package com.gotreaux.aoc.puzzles.year2025.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

class RtlVerticalWorksheetTest {

    @Test
    void of() {
        InputReader inputReader = new ResourceInputReader<>(TrashCompactorPuzzle.class);

        var input = inputReader.getInputList();

        var worksheet = RtlVerticalWorksheet.of(input);
        var operandLists = worksheet.getOperandLists();
        var operators = worksheet.getOperators();

        assertEquals(4, operandLists.size());
        assertEquals(List.of(4L, 431L, 623L), operandLists.getFirst());
        assertEquals(List.of(175L, 581L, 32L), operandLists.get(1));
        assertEquals(List.of(8L, 248L, 369L), operandLists.get(2));
        assertEquals(List.of(356L, 24L, 1L), operandLists.getLast());
        assertEquals(
                operators,
                List.of(
                        Operator.ADDITION,
                        Operator.MULTIPLICATION,
                        Operator.ADDITION,
                        Operator.MULTIPLICATION));
    }
}
