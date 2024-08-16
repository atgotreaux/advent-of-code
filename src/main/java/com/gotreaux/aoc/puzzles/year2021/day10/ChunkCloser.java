package com.gotreaux.aoc.puzzles.year2021.day10;

import java.util.Arrays;
import org.springframework.lang.Nullable;

enum ChunkCloser {
    PARENTHESIS(')', 3, 1),
    SQUARE_BRACKET(']', 57, 2),
    BRACE('}', 1197, 3),
    ANGLE_BRACKET('>', 25137, 4);

    private final char label;
    private final int errorScore;
    private final int autoCompleteScore;

    ChunkCloser(char label, int errorScore, int autoCompleteScore) {
        this.label = label;
        this.errorScore = errorScore;
        this.autoCompleteScore = autoCompleteScore;
    }

    private char getLabel() {
        return label;
    }

    int getErrorScore() {
        return errorScore;
    }

    int getAutoCompleteScore() {
        return autoCompleteScore;
    }

    static @Nullable ChunkCloser fromLabel(char label) {
        return Arrays.stream(values())
                .filter(chunkCloser -> chunkCloser.getLabel() == label)
                .findFirst()
                .orElse(null);
    }
}
