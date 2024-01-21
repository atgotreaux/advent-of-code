package com.gotreaux.aoc.puzzles.year2016.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.Test;

class KeypadTest {
    @Test
    void moveUp() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String label = String.valueOf(generator.nextInt());
        String up = String.valueOf(generator.nextInt());

        Key key =
                new Key(
                        label,
                        up,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));
        Key upKey =
                new Key(
                        up,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(key, upKey);
        Keypad keypad = new Keypad(keys);

        assertEquals(upKey, keypad.move(key, Instruction.UP));
    }

    @Test
    void moveDown() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String label = String.valueOf(generator.nextInt());
        String down = String.valueOf(generator.nextInt());

        Key key =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        down,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));
        Key downKey =
                new Key(
                        down,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(key, downKey);
        Keypad keypad = new Keypad(keys);

        assertEquals(downKey, keypad.move(key, Instruction.DOWN));
    }

    @Test
    void moveLeft() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String label = String.valueOf(generator.nextInt());
        String left = String.valueOf(generator.nextInt());

        Key key =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        left,
                        String.valueOf(generator.nextInt()));
        Key leftKey =
                new Key(
                        left,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(key, leftKey);
        Keypad keypad = new Keypad(keys);

        assertEquals(leftKey, keypad.move(key, Instruction.LEFT));
    }

    @Test
    void moveRight() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String label = String.valueOf(generator.nextInt());
        String right = String.valueOf(generator.nextInt());

        Key key =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        right);
        Key rightKey =
                new Key(
                        right,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(key, rightKey);
        Keypad keypad = new Keypad(keys);

        assertEquals(rightKey, keypad.move(key, Instruction.RIGHT));
    }

    @Test
    void throwsIfCannotFindTarget() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Key key = new Key("1", "2", "3", "4", "5");

        List<Key> keys = List.of(key);
        Keypad keypad = new Keypad(keys);

        Instruction instruction =
                Instruction.values()[generator.nextInt(Instruction.values().length)];

        assertThrows(NoSuchElementException.class, () -> keypad.move(key, instruction));
    }
}
