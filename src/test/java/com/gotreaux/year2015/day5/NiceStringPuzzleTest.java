package com.gotreaux.year2015.day5;

import com.gotreaux.input.StringInputProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NiceStringPuzzleTest {
    @Test
    void testUgknbfddgicrmopn() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("ugknbfddgicrmopn");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(1, puzzle.getPartOne());
    }

    @Test
    void testAaa() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("aaa");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(1, puzzle.getPartOne());
    }

    @Test
    void testJchzalrnumimnmhp() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("jchzalrnumimnmhp");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(0, puzzle.getPartOne());
    }

    @Test
    void testHaegwjzuvuyypxyu() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("haegwjzuvuyypxyu");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(0, puzzle.getPartOne());
    }

    @Test
    void testDvszwmarrgswjxmb() throws Exception {
        StringInputProvider inputProvider = new StringInputProvider("dvszwmarrgswjxmb");

        NiceStringPuzzle puzzle = new NiceStringPuzzle(inputProvider);

        puzzle.prepare();

        assertEquals(0, puzzle.getPartOne());
    }
}