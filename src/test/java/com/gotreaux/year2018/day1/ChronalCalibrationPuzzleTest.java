package com.gotreaux.year2018.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChronalCalibrationPuzzleTest {
    @Test
    void frequencyThree() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleOne.txt");

        puzzle.prepare();

        assertEquals(3, puzzle.getPartOne());
    }

    @Test
    void frequencyZero() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleTwo.txt");

        puzzle.prepare();

        assertEquals(0, puzzle.getPartOne());
    }

    @Test
    void frequencyNegativeSix() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleThree.txt");

        puzzle.prepare();

        assertEquals(-6, puzzle.getPartOne());
    }

    @Test
    void frequencyReachesDuplicateZero() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleFour.txt");

        puzzle.prepare();

        assertEquals(0, puzzle.getPartTwo());
    }

    @Test
    void frequencyReachesDuplicateTen() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleFive.txt");

        puzzle.prepare();

        assertEquals(10, puzzle.getPartTwo());
    }

    @Test
    void frequencyReachesDuplicateFive() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleSix.txt");

        puzzle.prepare();

        assertEquals(5, puzzle.getPartTwo());
    }

    @Test
    void frequencyReachesDuplicateFourteen() throws Exception {
        ChronalCalibrationPuzzle puzzle = new ChronalCalibrationPuzzle("ExampleSeven.txt");

        puzzle.prepare();

        assertEquals(14, puzzle.getPartTwo());
    }
}