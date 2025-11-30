package com.gotreaux.aoc.puzzles.year2019.day2;

import org.jspecify.annotations.Nullable;

record IntcodeProgram(@Nullable Integer noun, @Nullable Integer verb) {

    int process(int[] program) {
        var length = program.length;
        if (noun != null) {
            program[1] = noun;
        }
        if (verb != null) {
            program[2] = verb;
        }

        var runProgram = true;
        for (var i = 0; i < length && runProgram; i += 4) {
            var opcode = program[i];
            switch (opcode) {
                case 1 -> {
                    var augendIndex = program[i + 1];
                    var addendIndex = program[i + 2];
                    var sumIndex = program[i + 3];
                    program[sumIndex] = program[augendIndex] + program[addendIndex];
                }
                case 2 -> {
                    var multiplicandIndex = program[i + 1];
                    var multiplierIndex = program[i + 2];
                    var productIndex = program[i + 3];
                    program[productIndex] = program[multiplicandIndex] * program[multiplierIndex];
                }
                case 99 -> runProgram = false;
                default ->
                        throw new IllegalArgumentException(
                                "Unexpected Opcode '%d'".formatted(opcode));
            }
        }

        return program[0];
    }
}
