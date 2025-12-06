package com.gotreaux.aoc.puzzles.year2017.day8;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Instruction implements LabeledEnum<String> {
    INCREASE("inc"),
    DECREASE("dec");

    private final String label;

    Instruction(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
