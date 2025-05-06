package com.gotreaux.aoc.puzzles.year2018.day7;

record Requirement(String prereq, String step) {

    static Requirement of(String line) {
        String[] parts = line.split(" ");

        return new Requirement(parts[1], parts[7]);
    }
}
