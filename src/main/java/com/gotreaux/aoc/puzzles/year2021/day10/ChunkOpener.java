package com.gotreaux.aoc.puzzles.year2021.day10;

import java.util.Arrays;
import org.jspecify.annotations.Nullable;

enum ChunkOpener {
    PARENTHESIS('(', ChunkCloser.PARENTHESIS),
    SQUARE_BRACKET('[', ChunkCloser.SQUARE_BRACKET),
    BRACE('{', ChunkCloser.BRACE),
    ANGLE_BRACKET('<', ChunkCloser.ANGLE_BRACKET);

    private final char label;
    private final ChunkCloser closer;

    ChunkOpener(char label, ChunkCloser closer) {
        this.label = label;
        this.closer = closer;
    }

    private char getLabel() {
        return label;
    }

    ChunkCloser getCloser() {
        return closer;
    }

    static @Nullable ChunkOpener of(char label) {
        return Arrays.stream(values())
                .filter(chunkOpener -> chunkOpener.getLabel() == label)
                .findFirst()
                .orElse(null);
    }

    boolean matches(ChunkCloser closer) {
        return this.closer == closer;
    }
}
