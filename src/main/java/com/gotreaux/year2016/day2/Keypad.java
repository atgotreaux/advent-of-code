package com.gotreaux.year2016.day2;

import java.util.List;
import java.util.NoSuchElementException;

public class Keypad {
    private final List<Key> keys;

    public Keypad(List<Key> keys) {
        this.keys = keys;
    }

    public Key move(Key key, Instruction instruction) throws NoSuchElementException {
        String movedLabel =
                switch (instruction) {
                    case UP -> key.up();
                    case DOWN -> key.down();
                    case LEFT -> key.left();
                    case RIGHT -> key.right();
                };

        return this.keys.stream()
                .filter(keyRecord -> keyRecord.label().equals(movedLabel))
                .findFirst()
                .orElseThrow();
    }
}
