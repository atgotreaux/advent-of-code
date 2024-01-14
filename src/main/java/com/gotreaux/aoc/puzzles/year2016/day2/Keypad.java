package com.gotreaux.aoc.puzzles.year2016.day2;

import java.util.List;
import java.util.NoSuchElementException;

class Keypad {
    private final List<Key> keys;

    Keypad(List<Key> keys) {
        this.keys = keys;
    }

    Key move(Key key, Instruction instruction) throws NoSuchElementException {
        String movedLabel =
                switch (instruction) {
                    case UP -> key.up();
                    case DOWN -> key.down();
                    case LEFT -> key.left();
                    case RIGHT -> key.right();
                };

        return keys.stream()
                .filter(keyRecord -> keyRecord.label().equals(movedLabel))
                .findFirst()
                .orElseThrow();
    }
}
