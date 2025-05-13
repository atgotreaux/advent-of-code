package com.gotreaux.aoc.puzzles.year2015.day21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.input.reader.ResourceInputReader;
import org.junit.jupiter.api.Test;

class BossTest {

    @Test
    void of() throws Exception {
        InputReader inputReader = new ResourceInputReader<>(RpgSimulator20xxPuzzle.class);
        var input = inputReader.getInputList();

        var boss = Boss.of(input);

        assertEquals(12, boss.hitPoints());
        assertEquals(7, boss.damage());
        assertEquals(2, boss.armor());
    }
}
