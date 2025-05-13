package com.gotreaux.aoc.puzzles.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gotreaux.aoc.utils.RelativeDirection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class KeypadTest {
    @Test
    void moveUp() {
        var generator = RandomGenerator.getDefault();

        var label = String.valueOf(generator.nextInt());
        var up = String.valueOf(generator.nextInt());

        var key =
                new Key(
                        label,
                        up,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));
        var upKey =
                new Key(
                        up,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        var keys = List.of(key, upKey);
        var keypad = new Keypad(keys);

        assertEquals(upKey, keypad.move(key, RelativeDirection.UP));
    }

    @Test
    void moveDown() {
        var generator = RandomGenerator.getDefault();

        var label = String.valueOf(generator.nextInt());
        var down = String.valueOf(generator.nextInt());

        var key =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        down,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));
        var downKey =
                new Key(
                        down,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        var keys = List.of(key, downKey);
        var keypad = new Keypad(keys);

        assertEquals(downKey, keypad.move(key, RelativeDirection.DOWN));
    }

    @Test
    void moveLeft() {
        var generator = RandomGenerator.getDefault();

        var label = String.valueOf(generator.nextInt());
        var left = String.valueOf(generator.nextInt());

        var key =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        left,
                        String.valueOf(generator.nextInt()));
        var leftKey =
                new Key(
                        left,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        var keys = List.of(key, leftKey);
        var keypad = new Keypad(keys);

        assertEquals(leftKey, keypad.move(key, RelativeDirection.LEFT));
    }

    @Test
    void moveRight() {
        var generator = RandomGenerator.getDefault();

        var label = String.valueOf(generator.nextInt());
        var right = String.valueOf(generator.nextInt());

        var key =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        right);
        var rightKey =
                new Key(
                        right,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        var keys = List.of(key, rightKey);
        var keypad = new Keypad(keys);

        assertEquals(rightKey, keypad.move(key, RelativeDirection.RIGHT));
    }

    @Test
    void throwsIfCannotFindTarget() {
        var generator = RandomGenerator.getDefault();

        var key = new Key("1", "2", "3", "4", "5");

        var keys = List.of(key);
        var keypad = new Keypad(keys);

        var directions = Arrays.asList(RelativeDirection.values());
        Collections.shuffle(keys, generator);
        var direction = directions.getFirst();

        assertThrows(NoSuchElementException.class, () -> keypad.move(key, direction));
    }
}
