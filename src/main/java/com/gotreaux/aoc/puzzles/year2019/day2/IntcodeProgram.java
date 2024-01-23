package com.gotreaux.aoc.puzzles.year2019.day2;

record IntcodeProgram(int noun, int verb) {

    int process(int[] program) {
        int length = program.length;
        program[1] = noun;
        program[2] = verb;

        boolean runProgram = true;
        for (int i = 0; i < length && runProgram; i += 4) {
            switch (program[i]) {
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
            }
        }

        return program[0];
    }
}
