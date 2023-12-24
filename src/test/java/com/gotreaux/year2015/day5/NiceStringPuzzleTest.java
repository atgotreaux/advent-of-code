package com.gotreaux.year2015.day5;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NiceStringPuzzleTest {
    @Test
    void testUgknbfddgicrmopn() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("ugknbfddgicrmopn");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(1L, puzzle.getPartOne());
    }

    @Test
    void testAaa() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("aaa");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(1L, puzzle.getPartOne());
    }

    @Test
    void testJchzalrnumimnmhp() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("jchzalrnumimnmhp");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartOne());
    }

    @Test
    void testHaegwjzuvuyypxyu() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("haegwjzuvuyypxyu");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartOne());
    }

    @Test
    void testDvszwmarrgswjxmb() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("dvszwmarrgswjxmb");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartOne());
    }

    @Test
    void testQjhvhtzxzqqjkmpb() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("qjhvhtzxzqqjkmpb");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(1L, puzzle.getPartTwo());
    }

    @Test
    void testXxyxx() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("xxyxx");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(1L, puzzle.getPartTwo());
    }

    @Test
    void testUurcxstgmygtbstg() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("uurcxstgmygtbstg");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartTwo());
    }

    @Test
    void testIeodomkazucvgmuy() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("ieodomkazucvgmuy");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        assertEquals(0L, puzzle.getPartTwo());
    }
}