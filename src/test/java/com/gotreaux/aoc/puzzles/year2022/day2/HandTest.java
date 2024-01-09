package com.gotreaux.aoc.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class HandTest {
    @Test
    void parseOpponentRock() {
        assertEquals(Hand.ROCK, Hand.fromOpponentLabel('A'));
    }

    @Test
    void parseOpponentPaper() {
        assertEquals(Hand.PAPER, Hand.fromOpponentLabel('B'));
    }

    @Test
    void parseOpponentScissors() {
        assertEquals(Hand.SCISSORS, Hand.fromOpponentLabel('C'));
    }

    @Test
    void throwsIfCannotParseOpponentLabel() {
        assertThrows(NoSuchElementException.class, () -> Hand.fromOpponentLabel('D'));
    }

    @Test
    void parseStrategyRock() {
        assertEquals(Hand.ROCK, Hand.fromEncryptedStrategyLabel('X'));
    }

    @Test
    void parseStrategyPaper() {
        assertEquals(Hand.PAPER, Hand.fromEncryptedStrategyLabel('Y'));
    }

    @Test
    void parseStrategyScissors() {
        assertEquals(Hand.SCISSORS, Hand.fromEncryptedStrategyLabel('Z'));
    }

    @Test
    void throwsIfCannotParseEncryptedStrategyLabel() {
        assertThrows(NoSuchElementException.class, () -> Hand.fromEncryptedStrategyLabel('W'));
    }

    @Test
    void outcomeLoseToRock() {
        assertEquals(Hand.SCISSORS, Hand.fromStrategyOutcomeLabel(Hand.ROCK, 'X'));
    }

    @Test
    void outcomeLoseToPaper() {
        assertEquals(Hand.ROCK, Hand.fromStrategyOutcomeLabel(Hand.PAPER, 'X'));
    }

    @Test
    void outcomeLoseToScissors() {
        assertEquals(Hand.PAPER, Hand.fromStrategyOutcomeLabel(Hand.SCISSORS, 'X'));
    }

    @Test
    void outcomeWinToRock() {
        assertEquals(Hand.PAPER, Hand.fromStrategyOutcomeLabel(Hand.ROCK, 'Z'));
    }

    @Test
    void outcomeWinToPaper() {
        assertEquals(Hand.SCISSORS, Hand.fromStrategyOutcomeLabel(Hand.PAPER, 'Z'));
    }

    @Test
    void outcomeWinToScissors() {
        assertEquals(Hand.ROCK, Hand.fromStrategyOutcomeLabel(Hand.SCISSORS, 'Z'));
    }

    @RepeatedTest(5)
    void outcomeDraw() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Hand hand = Hand.values()[generator.nextInt(Hand.values().length)];

        assertEquals(hand, Hand.fromStrategyOutcomeLabel(hand, 'Y'));
    }

    @Test
    void throwsIfCannotParseOutcomeStrategyLabel() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Hand hand = Hand.values()[generator.nextInt(Hand.values().length)];

        assertThrows(NoSuchElementException.class, () -> Hand.fromStrategyOutcomeLabel(hand, 'W'));
    }
}
