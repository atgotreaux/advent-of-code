package com.gotreaux.aoc.puzzles.year2015.day9;

record Route(String from, String to, int distance) {
    boolean matches(String from, String to) {
        return (this.from.equals(from) && this.to.equals(to))
                || (this.from.equals(to) && this.to.equals(from));
    }
}
