package com.gotreaux.aoc.puzzles.year2020.day8;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Operation implements LabeledEnum<String> {
    ACC("acc"),
    JMP("jmp"),
    NOP("nop");

    private final String label;

    Operation(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
