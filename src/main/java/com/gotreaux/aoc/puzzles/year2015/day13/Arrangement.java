package com.gotreaux.aoc.puzzles.year2015.day13;

record Arrangement(String relative, String neighbor, int happiness) {

    static Arrangement of(String line) {
        var parts = line.split(" ");

        var relative = parts[0];
        var neighbor = parts[10].replace(".", "");

        var happiness = Integer.parseInt(parts[3]);
        if (parts[2].equals("lose")) {
            happiness = -happiness;
        }

        return new Arrangement(relative, neighbor, happiness);
    }
}
