package com.gotreaux.aoc.puzzles.year2025.day6;

import com.gotreaux.aoc.utils.enums.LabeledEnum;
import java.util.Collection;

enum Operator implements LabeledEnum<Character> {
    ADDITION('+'),
    MULTIPLICATION('*');

    private final char label;

    Operator(char label) {
        this.label = label;
    }

    @Override
    public Character getLabel() {
        return label;
    }

    long operate(Collection<Long> operands) {
        return switch (this) {
            case ADDITION -> operands.stream().mapToLong(Long::longValue).sum();
            case MULTIPLICATION -> operands.stream().reduce(1L, Math::multiplyExact);
        };
    }
}
