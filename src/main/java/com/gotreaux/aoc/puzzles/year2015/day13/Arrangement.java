package com.gotreaux.aoc.puzzles.year2015.day13;

record Arrangement(String relative, String neighbor, int happiness) {

    static Arrangement of(String line) {
        String[] parts = line.split(" ");

        String relative = parts[0];
        String neighbor = parts[10].replace(".", "");

        int happiness = Integer.parseInt(parts[3]);
        if (parts[2].equals("lose")) {
            happiness = -happiness;
        }

        return new Arrangement(relative, neighbor, happiness);
    }
}
