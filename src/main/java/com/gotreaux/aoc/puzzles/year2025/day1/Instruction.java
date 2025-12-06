package com.gotreaux.aoc.puzzles.year2025.day1;

import com.gotreaux.aoc.utils.enums.EnumUtils;

record Instruction(Rotation rotation, int distance) {

    static Instruction of(String line) {
        var rotation = EnumUtils.of(Rotation.class, line.charAt(0));
        var distance = Integer.parseInt(line.substring(1));

        return new Instruction(rotation, distance);
    }

    int rotate(int dial, int size) {
        return switch (rotation) {
            case LEFT -> Math.floorMod(dial - distance, size);
            case RIGHT -> (dial + distance) % size;
        };
    }

    int countZeroes(int dial, int size) {
        var result = 0;

        switch (rotation) {
            case LEFT -> {
                if (distance >= dial) {
                    result = ((distance - dial) / size);
                    if (dial != 0) {
                        result++;
                    }
                }
            }
            case RIGHT -> {
                if (dial + distance >= size) {
                    result = (dial + distance) / size;
                }
            }
        }

        return result;
    }
}
