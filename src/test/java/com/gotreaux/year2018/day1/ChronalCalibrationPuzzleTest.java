package com.gotreaux.year2018.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChronalCalibrationPuzzleTest {
    @Test
    void frequencyThree() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleOne.txt");

        assertEquals(3L, puzzle.getPartOne());
    }

    @Test
    void frequencyZero() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleTwo.txt");

        assertEquals(0L, puzzle.getPartOne());
    }

    @Test
    void frequencyNegativeSix() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleThree.txt");

        assertEquals(-6L, puzzle.getPartOne());
    }

    @Test
    void frequencyReachesDuplicateZero() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleFour.txt");

        assertEquals(0L, puzzle.getPartTwo());
    }

    @Test
    void frequencyReachesDuplicateTen() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleFive.txt");

        assertEquals(10L, puzzle.getPartTwo());
    }

    @Test
    void frequencyReachesDuplicateFive() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleSix.txt");

        assertEquals(5L, puzzle.getPartTwo());
    }

    @Test
    void frequencyReachesDuplicateFourteen() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleSeven.txt");

        assertEquals(14L, puzzle.getPartTwo());
    }
}