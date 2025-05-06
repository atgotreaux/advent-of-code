package com.gotreaux.aoc.puzzles.year2015.day15;

record Ingredient(int capacity, int durability, int flavor, int texture, int calories) {

    static Ingredient of(String line) {
        String[] parts = line.replace(":", "").replace(",", "").split(" ");

        return new Ingredient(
                Integer.parseInt(parts[2]),
                Integer.parseInt(parts[4]),
                Integer.parseInt(parts[6]),
                Integer.parseInt(parts[8]),
                Integer.parseInt(parts[10]));
    }
}
