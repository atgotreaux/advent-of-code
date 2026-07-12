package com.gotreaux.aoc.service;

import com.gotreaux.aoc.puzzles.Puzzle;

record PuzzleKey(int year, int day) {

    static PuzzleKey of(Puzzle puzzle) {
        return new PuzzleKey(puzzle.getYear(), puzzle.getDay());
    }
}
