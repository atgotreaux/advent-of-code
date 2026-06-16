package com.gotreaux.aoc.utils.enums;

import org.jspecify.annotations.NullMarked;

@NullMarked
enum TestEnum implements LabeledEnum<Character> {
    FIRST('A'),
    SECOND('B'),
    THIRD('C');

    private final Character label;

    TestEnum(Character label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
