package com.gotreaux.aoc.puzzles.year2016.day2;

import com.gotreaux.aoc.utils.cartesian.RelativeDirection;
import java.util.Collection;
import java.util.Collections;

class Keypad {
    private final Collection<Key> keys;

    Keypad(Collection<Key> keys) {
        this.keys = Collections.unmodifiableCollection(keys);
    }

    Key move(Key key, RelativeDirection direction) {
        var movedLabel =
                switch (direction) {
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
