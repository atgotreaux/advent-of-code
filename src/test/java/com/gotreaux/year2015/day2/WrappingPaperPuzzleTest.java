package com.gotreaux.year2015.day2;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WrappingPaperPuzzleTest {
    @Test
    void twoByThreeByFourWrappingPaper() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("2x3x4");

        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(58, puzzle.getPartOne());
    }

    @Test
    void oneByOneByTenWrappingPaper() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("1x1x10");

        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(43, puzzle.getPartOne());
    }

    @Test
    void twoByThreeByFourRibbon() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("2x3x4");

        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(34, puzzle.getPartTwo());
    }

    @Test
    void oneByOneByTenRibbon() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("1x1x10");

        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(14, puzzle.getPartTwo());
    }
}