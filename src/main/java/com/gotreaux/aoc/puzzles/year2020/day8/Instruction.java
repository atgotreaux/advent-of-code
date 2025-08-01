package com.gotreaux.aoc.puzzles.year2020.day8;

record Instruction(Operation operation, int argument) {

    static Instruction of(String line) {
        var parts = line.split(" ");

        var operation = Operation.of(parts[0]);
        var argument = Integer.parseInt(parts[1]);

        return new Instruction(operation, argument);
    }
}
