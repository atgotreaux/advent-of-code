package com.gotreaux.aoc.puzzles.year2021.day10;

import com.gotreaux.aoc.utils.enums.LabeledEnum;

enum ChunkOpener implements LabeledEnum<Character> {
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

    @Override
    public Character getLabel() {
        return label;
    }

    ChunkCloser getCloser() {
        return closer;
    }

    boolean matches(ChunkCloser closer) {
        return this.closer == closer;
    }
}
