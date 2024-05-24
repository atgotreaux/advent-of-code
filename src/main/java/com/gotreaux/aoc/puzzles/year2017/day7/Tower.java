package com.gotreaux.aoc.puzzles.year2017.day7;

import java.util.List;

record Tower(String bottom, List<String> top) {
    boolean isHolding(String program) {
        return top.contains(program);
    }
}
