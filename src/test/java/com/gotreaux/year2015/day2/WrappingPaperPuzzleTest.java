package com.gotreaux.year2015.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrappingPaperPuzzleTest {
    @Test
    void twoByThreeByFourWrappingPaper() throws Exception {
        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle("TwoByThreeByFour.txt");

        puzzle.prepare();

        assertEquals(58, puzzle.getPartOne());
    }

    @Test
    void oneByOneByTenWrappingPaper() throws Exception {
        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle("OneByOneByTen.txt");

        puzzle.prepare();

        assertEquals(43, puzzle.getPartOne());
    }

    @Test
    void twoByThreeByFourRibbon() throws Exception {
        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle("TwoByThreeByFour.txt");

        puzzle.prepare();

        assertEquals(34, puzzle.getPartTwo());
    }

    @Test
    void oneByOneByTenRibbon() throws Exception {
        WrappingPaperPuzzle puzzle = new WrappingPaperPuzzle("OneByOneByTen.txt");

        puzzle.prepare();

        assertEquals(14, puzzle.getPartTwo());
    }
}