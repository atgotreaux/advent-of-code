package com.gotreaux.aoc.puzzles.year2022.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HandTest {
    @ParameterizedTest
    @MethodSource("provideParseOpponentHand")
    void parseOpponentHand(char label, Hand expectedHand) {
        assertEquals(expectedHand, Hand.ofOpponentLabel(label));
    }

    @Test
    void throwsIfCannotParseOpponentLabel() {
        assertThrows(NoSuchElementException.class, () -> Hand.ofOpponentLabel('D'));
    }

    @ParameterizedTest
    @MethodSource("provideParseStrategyHand")
    void parseStrategyHand(char label, Hand expectedHand) {
        assertEquals(expectedHand, Hand.ofEncryptedStrategyLabel(label));
    }

    @Test
    void throwsIfCannotParseEncryptedStrategyLabel() {
        assertThrows(NoSuchElementException.class, () -> Hand.ofEncryptedStrategyLabel('W'));
    }

    @ParameterizedTest
    @MethodSource("provideParseOutcomeLabel")
    void parseOutcomeLabel(char label, Hand opponentHand, Hand expectedHand) {
        assertEquals(expectedHand, Hand.ofStrategyOutcomeLabel(opponentHand, label));
    }

    @RepeatedTest(5)
    void outcomeDraw() {
        RandomGenerator generator = RandomGenerator.getDefault();

        List<Hand> hands = Arrays.asList(Hand.values());
        Collections.shuffle(hands, generator);
        Hand hand = hands.getFirst();

        assertEquals(hand, Hand.ofStrategyOutcomeLabel(hand, 'Y'));
    }

    @Test
    void throwsIfCannotParseOutcomeStrategyLabel() {
        RandomGenerator generator = RandomGenerator.getDefault();

        List<Hand> hands = Arrays.asList(Hand.values());
        Collections.shuffle(hands, generator);
        Hand hand = hands.getFirst();

        assertThrows(NoSuchElementException.class, () -> Hand.ofStrategyOutcomeLabel(hand, 'W'));
    }

    private static Stream<Arguments> provideParseOpponentHand() {
        return Stream.of(
                Arguments.of('A', Hand.ROCK),
                Arguments.of('B', Hand.PAPER),
                Arguments.of('C', Hand.SCISSORS));
    }

    private static Stream<Arguments> provideParseStrategyHand() {
        return Stream.of(
                Arguments.of('X', Hand.ROCK),
                Arguments.of('Y', Hand.PAPER),
                Arguments.of('Z', Hand.SCISSORS));
    }

    private static Stream<Arguments> provideParseOutcomeLabel() {
        return Stream.of(
                Arguments.of('X', Hand.ROCK, Hand.SCISSORS),
                Arguments.of('X', Hand.PAPER, Hand.ROCK),
                Arguments.of('X', Hand.SCISSORS, Hand.PAPER),
                Arguments.of('Z', Hand.ROCK, Hand.PAPER),
                Arguments.of('Z', Hand.PAPER, Hand.SCISSORS),
                Arguments.of('Z', Hand.SCISSORS, Hand.ROCK));
    }
}
