package com.gotreaux.aoc.puzzles.year2016.day2;

import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;

class Keypad {
    private final Collection<Key> keys;

    Keypad(Collection<Key> keys) {
        this.keys = Collections.unmodifiableCollection(keys);
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
