package com.gotreaux.aoc.puzzles.year2022.day2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Hand {
    ROCK('A', 'X', 1),
    PAPER('B', 'Y', 2),
    SCISSORS('C', 'Z', 3);

    private final char opponentLabel;
    private final char strategyLabel;
    private final int weight;

    Hand(char opponentLabel, char strategyLabel, int weight) {
        this.opponentLabel = opponentLabel;
        this.strategyLabel = strategyLabel;
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public static Hand fromOpponentLabel(char opponentLabel) throws NoSuchElementException {
        return Arrays.stream(Hand.values())
                .filter(hand -> hand.opponentLabel == opponentLabel)
                .findFirst()
                .orElseThrow();
    }

    public static Hand fromEncryptedStrategyLabel(char strategyLabel)
            throws NoSuchElementException {
        return Arrays.stream(Hand.values())
                .filter(hand -> hand.strategyLabel == strategyLabel)
                .findFirst()
                .orElseThrow();
    }

    public static Hand fromStrategyOutcomeLabel(Hand opponentHand, char outcomeLabel)
            throws NoSuchElementException {
        if (outcomeLabel == 'X') {
            return switch (opponentHand) {
                case ROCK -> SCISSORS;
                case PAPER -> ROCK;
                case SCISSORS -> PAPER;
            };
        }

        if (outcomeLabel == 'Y') {
            return opponentHand;
        }

        if (outcomeLabel == 'Z') {
            return switch (opponentHand) {
                case ROCK -> PAPER;
                case PAPER -> SCISSORS;
                case SCISSORS -> ROCK;
            };
        }

        throw new NoSuchElementException(String.valueOf(outcomeLabel));
    }
}
