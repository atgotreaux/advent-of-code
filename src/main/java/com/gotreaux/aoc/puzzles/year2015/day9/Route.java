package com.gotreaux.aoc.puzzles.year2015.day9;

record Route(String from, String to, int distance) {

    static Route of(String line) {
        String[] parts = line.split(" ");

        return new Route(parts[0], parts[2], Integer.parseInt(parts[4]));
    }

    boolean matches(String from, String to) {
        return (this.from.equals(from) && this.to.equals(to))
                || (this.from.equals(to) && this.to.equals(from));
    }
}
