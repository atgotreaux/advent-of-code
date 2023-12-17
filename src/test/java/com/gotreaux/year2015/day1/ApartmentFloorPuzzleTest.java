package com.gotreaux.year2015.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentFloorPuzzleTest {
    @Test
    void floorZeroExampleOne() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Floor0Example1.txt");

        puzzle.prepare();

        assertEquals(0, puzzle.getPartOne());
    }

    @Test
    void floorZeroExampleTwo() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Floor0Example2.txt");

        puzzle.prepare();

        assertEquals(0, puzzle.getPartOne());
    }

    @Test
    void floorThreeExampleOne() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Floor3Example1.txt");

        puzzle.prepare();

        assertEquals(3, puzzle.getPartOne());
    }

    @Test
    void floorThreeExampleTwo() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Floor3Example2.txt");

        puzzle.prepare();

        assertEquals(3, puzzle.getPartOne());
    }

    @Test
    void floorThreeExampleThree() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Floor3Example3.txt");

        puzzle.prepare();

        assertEquals(3, puzzle.getPartOne());
    }

    @Test
    void basementOneExampleOne() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Basement1Example1.txt");

        puzzle.prepare();

        assertEquals(-1, puzzle.getPartOne());
    }

    @Test
    void basementOneExampleTwo() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Basement1Example2.txt");

        puzzle.prepare();

        assertEquals(-1, puzzle.getPartOne());
    }

    @Test
    void basementThreeExampleOne() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Basement3Example1.txt");

        puzzle.prepare();

        assertEquals(-3, puzzle.getPartOne());
    }

    @Test
    void basementThreeExampleTwo() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("Basement3Example2.txt");

        puzzle.prepare();

        assertEquals(-3, puzzle.getPartOne());
    }

    @Test
    void basementAtPositionOne() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("BasementAtPosition1.txt");

        puzzle.prepare();

        assertEquals(1, puzzle.getPartTwo());
    }

    @Test
    void basementAtPositionFive() throws Exception {
        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle("BasementAtPosition5.txt");

        puzzle.prepare();

        assertEquals(5, puzzle.getPartTwo());
    }
}