package com.gotreaux.year2016.day2;

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

        Key one =
                new Key(
                        label,
                        up,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));
        Key two =
                new Key(
                        up,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(one, two);
        Keypad keypad = new Keypad(keys);

        assertEquals(two, keypad.move(one, Instruction.UP));
    }

    @Test
    void moveDown() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String label = String.valueOf(generator.nextInt());
        String down = String.valueOf(generator.nextInt());

        Key one =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        down,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));
        Key two =
                new Key(
                        down,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(one, two);
        Keypad keypad = new Keypad(keys);

        assertEquals(two, keypad.move(one, Instruction.DOWN));
    }

    @Test
    void moveLeft() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String label = String.valueOf(generator.nextInt());
        String left = String.valueOf(generator.nextInt());

        Key one =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        left,
                        String.valueOf(generator.nextInt()));
        Key two =
                new Key(
                        left,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(one, two);
        Keypad keypad = new Keypad(keys);

        assertEquals(two, keypad.move(one, Instruction.LEFT));
    }

    @Test
    void moveRight() {
        RandomGenerator generator = RandomGenerator.getDefault();

        String label = String.valueOf(generator.nextInt());
        String right = String.valueOf(generator.nextInt());

        Key one =
                new Key(
                        label,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        right);
        Key two =
                new Key(
                        right,
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()),
                        String.valueOf(generator.nextInt()));

        List<Key> keys = List.of(one, two);
        Keypad keypad = new Keypad(keys);

        assertEquals(two, keypad.move(one, Instruction.RIGHT));
    }

    @Test
    void throwsIfCannotFindTarget() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Key one = new Key("1", "2", "3", "4", "5");

        List<Key> keys = List.of(one);
        Keypad keypad = new Keypad(keys);

        Instruction instruction =
                Instruction.values()[generator.nextInt(Instruction.values().length)];

        assertThrows(NoSuchElementException.class, () -> keypad.move(one, instruction));
    }
}
