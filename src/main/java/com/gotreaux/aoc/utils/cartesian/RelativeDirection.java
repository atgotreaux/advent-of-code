package com.gotreaux.aoc.utils.cartesian;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

public enum RelativeDirection implements LabeledEnum<Character> {
    UP('U'),
    DOWN('D'),
    LEFT('L'),
    RIGHT('R');

    private final char label;

    RelativeDirection(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }
}
