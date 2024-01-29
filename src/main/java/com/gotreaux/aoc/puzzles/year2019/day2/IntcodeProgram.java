package com.gotreaux.aoc.puzzles.year2019.day2;

import org.springframework.lang.Nullable;

record IntcodeProgram(@Nullable Integer noun, @Nullable Integer verb) {

    int process(int[] program) throws IllegalArgumentException {
        int length = program.length;
        if (noun != null) {
            program[1] = noun;
        }
        if (verb != null) {
            program[2] = verb;
        }

        boolean runProgram = true;
        for (int i = 0; i < length && runProgram; i += 4) {
            int opcode = program[i];
            switch (opcode) {
                case 1:
                    int augendIndex = program[i + 1];
                    int addendIndex = program[i + 2];
                    int sumIndex = program[i + 3];
                    program[sumIndex] = program[augendIndex] + program[addendIndex];
                    break;
                case 2:
                    int multiplicandIndex = program[i + 1];
                    int multiplierIndex = program[i + 2];
                    int productIndex = program[i + 3];
                    program[productIndex] = program[multiplicandIndex] * program[multiplierIndex];
                    break;
                case 99:
                    runProgram = false;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected Opcode '%d'".formatted(opcode));
            }
        }

        return program[0];
    }
}
