package com.gotreaux.aoc.puzzles.year2015.day7.gate;

import com.gotreaux.aoc.puzzles.year2015.day7.Circuit;

@FunctionalInterface
public interface Gate {
    int evaluate(Circuit circuit);
}
