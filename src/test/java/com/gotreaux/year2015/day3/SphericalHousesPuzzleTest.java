package com.gotreaux.year2015.day3;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SphericalHousesPuzzleTest {
    @Test
    void testSantaMovesEast() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider(">");

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(2, puzzle.getPartOne());
    }

    @Test
    void testSantaFourDeliveries() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("^>v<");

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(4, puzzle.getPartOne());
    }

    @Test
    void testSantaLuckyDeliveries() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("^v^v^v^v^v");

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(2, puzzle.getPartOne());
    }

    @Test
    void testAssistedThreeDeliveries() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("^v");

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(3, puzzle.getPartTwo());
    }

    @Test
    void testAssistedReturnToStartDeliveries() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("^>v<");

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(3, puzzle.getPartTwo());
    }

    @Test
    void testAssistedNorthSouthDeliveries() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("^v^v^v^v^v");

        SphericalHousesPuzzle puzzle = new SphericalHousesPuzzle(inputProvider);

        assertEquals(11, puzzle.getPartTwo());
    }
}