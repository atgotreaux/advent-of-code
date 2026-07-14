package com.gotreaux.aoc.puzzles.year2019.day8;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum Pixel implements LabeledEnum<Integer> {
    BLACK(0),
    WHITE(1),
    TRANSPARENT(2);

    private final int label;

    Pixel(int label) {
        this.label = label;
    }

    @Override
    public Integer getLabel() {
        return label;
    }
}
