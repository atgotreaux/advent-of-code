package com.gotreaux.aoc.puzzles.year2015.day21;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
