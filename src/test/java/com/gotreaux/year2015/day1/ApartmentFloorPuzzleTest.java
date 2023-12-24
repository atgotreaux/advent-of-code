package com.gotreaux.year2015.day1;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApartmentFloorPuzzleTest {
    @Test
    void floorZeroExampleOne() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("(())");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartOne());
    }

    @Test
    void floorZeroExampleTwo() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("()()");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartOne());
    }

    @Test
    void floorThreeExampleOne() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("(((");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(3L, puzzle.getPartOne());
    }

    @Test
    void floorThreeExampleTwo() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("(()(()(");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(3L, puzzle.getPartOne());
    }

    @Test
    void floorThreeExampleThree() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("))(((((");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(3L, puzzle.getPartOne());
    }

    @Test
    void basementOneExampleOne() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("())");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(-1L, puzzle.getPartOne());
    }

    @Test
    void basementOneExampleTwo() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("))(");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(-1L, puzzle.getPartOne());
    }

    @Test
    void basementThreeExampleOne() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(")))");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(-3L, puzzle.getPartOne());
    }

    @Test
    void basementThreeExampleTwo() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(")())())");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(-3L, puzzle.getPartOne());
    }

    @Test
    void basementAtPositionOne() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(")");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(1, puzzle.getPartTwo());
    }

    @Test
    void basementAtPositionFive() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("()())");

        ApartmentFloorPuzzle puzzle = new ApartmentFloorPuzzle(inputProvider);

        assertEquals(5, puzzle.getPartTwo());
    }
}