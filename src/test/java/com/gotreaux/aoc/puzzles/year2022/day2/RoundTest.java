package com.gotreaux.aoc.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RoundTest {
    @ParameterizedTest
    @MethodSource("provideScore")
    void score(Hand opponentHand, Hand strategyHand, int expectedScore) {
        var round = new Round(opponentHand, strategyHand);

        assertEquals(expectedScore, round.getScore());
    }

    @RepeatedTest(5)
    void draw() {
        var generator = RandomGenerator.getDefault();

        var hands = Arrays.asList(Hand.values());
        Collections.shuffle(hands, generator);
        var hand = hands.getFirst();

        var round = new Round(hand, hand);

        assertEquals(3, round.getScore());
    }

    private static Stream<Arguments> provideScore() {
        return Stream.of(
                Arguments.of(Hand.SCISSORS, Hand.ROCK, 6),
                Arguments.of(Hand.PAPER, Hand.SCISSORS, 6),
                Arguments.of(Hand.ROCK, Hand.PAPER, 6),
                Arguments.of(Hand.ROCK, Hand.SCISSORS, 0),
                Arguments.of(Hand.SCISSORS, Hand.PAPER, 0),
                Arguments.of(Hand.PAPER, Hand.ROCK, 0));
    }
}
