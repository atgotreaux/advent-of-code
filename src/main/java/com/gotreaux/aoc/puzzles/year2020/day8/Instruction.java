package com.gotreaux.aoc.puzzles.year2020.day8;

import com.gotreaux.aoc.utils.enums.EnumUtils;

record Instruction(Operation operation, int argument) {

    static Instruction of(String line) {
        var parts = line.split(" ");

        var operation = EnumUtils.of(Operation.class, parts[0]);
        var argument = Integer.parseInt(parts[1]);

        return new Instruction(operation, argument);
    }
}
