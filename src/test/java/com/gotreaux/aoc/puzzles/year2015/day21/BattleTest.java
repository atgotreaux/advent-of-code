package com.gotreaux.aoc.puzzles.year2015.day21;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class BattleTest {

    @Test
    void isWin() throws Exception {
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

        var battle = new Battle(player, boss);

        assertTrue(battle.isWin());
    }
}
