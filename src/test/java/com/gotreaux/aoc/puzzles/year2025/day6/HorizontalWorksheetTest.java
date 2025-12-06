package com.gotreaux.aoc.puzzles.year2025.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.List;
import org.junit.jupiter.api.Test;

class HorizontalWorksheetTest {

    @Test
    void of() {
        InputReader inputReader = new ResourceInputReader<>(TrashCompactorPuzzle.class);

        var input = inputReader.getInputList();

        var worksheet = HorizontalWorksheet.of(input);
        var operandLists = worksheet.getOperandLists();
        var operators = worksheet.getOperators();

        assertEquals(3, operandLists.size());
        assertEquals(List.of(123L, 328L, 51L, 64L), operandLists.getFirst());
        assertEquals(List.of(45L, 64L, 387L, 23L), operandLists.get(1));
        assertEquals(List.of(6L, 98L, 215L, 314L), operandLists.getLast());
        assertEquals(
                operators,
                List.of(
                        Operator.MULTIPLICATION,
                        Operator.ADDITION,
                        Operator.MULTIPLICATION,
                        Operator.ADDITION));
    }
}
