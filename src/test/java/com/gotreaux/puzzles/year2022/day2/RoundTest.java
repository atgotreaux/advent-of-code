package com.gotreaux.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.random.RandomGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class RoundTest {
    @Test
    void rockBeatsScissors() {
        Round round = new Round(Hand.SCISSORS, Hand.ROCK);

        assertEquals(6L, round.getScore());
    }

    @Test
    void scissorsBeatsPaper() {
        Round round = new Round(Hand.PAPER, Hand.SCISSORS);

        assertEquals(6L, round.getScore());
    }

    @Test
    void paperBeatsRock() {
        Round round = new Round(Hand.ROCK, Hand.PAPER);

        assertEquals(6L, round.getScore());
    }

    @Test
    void scissorsLosesToRock() {
        Round round = new Round(Hand.ROCK, Hand.SCISSORS);

        assertEquals(0L, round.getScore());
    }

    @Test
    void paperLosesToScissors() {
        Round round = new Round(Hand.SCISSORS, Hand.PAPER);

        assertEquals(0L, round.getScore());
    }

    @Test
    void rockLosesToPaper() {
        Round round = new Round(Hand.PAPER, Hand.ROCK);

        assertEquals(0L, round.getScore());
    }

    @RepeatedTest(5)
    void draw() {
        RandomGenerator generator = RandomGenerator.getDefault();

        Hand hand = Hand.values()[generator.nextInt(Hand.values().length)];

        Round round = new Round(hand, hand);

        assertEquals(3L, round.getScore());
    }
}
