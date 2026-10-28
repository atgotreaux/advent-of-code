package com.gotreaux.aoc.puzzles.year2015.day21;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void calculateDamage() {
        var player =
                new Player(
                        8,
                        Weapon.SHORTSWORD,
                        Optional.of(Armor.PLATEMAIL),
                        Optional.empty(),
                        Optional.empty());

        assertEquals(5, player.calculateDamage());
    }

    @Test
    void calculateArmor() {
        var player =
                new Player(
                        8,
                        Weapon.SHORTSWORD,
                        Optional.of(Armor.PLATEMAIL),
                        Optional.empty(),
                        Optional.empty());

        assertEquals(5, player.calculateArmor());
    }

    @Test
    void wins() {
        InputReader inputReader = new ResourceInputReader<>(RpgSimulator20xxPuzzle.class);
        var input = inputReader.getInputList();

        var boss = Boss.of(input);
        var player =
                new Player(
                        8,
                        Weapon.SHORTSWORD,
                        Optional.of(Armor.PLATEMAIL),
                        Optional.empty(),
                        Optional.empty());

        assertTrue(player.wins(boss));
    }

    @Test
    void calculateCost() {
        var player =
                new Player(
                        8,
                        Weapon.SHORTSWORD,
                        Optional.of(Armor.PLATEMAIL),
                        Optional.empty(),
                        Optional.empty());

        assertEquals(112, player.calculateCost());
    }
}
