package com.gotreaux.aoc.puzzles.year2022.day2;

import java.util.Arrays;
import java.util.NoSuchElementException;

enum Hand {
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

    private char getOpponentLabel() {
        return opponentLabel;
    }

    private char getStrategyLabel() {
        return strategyLabel;
    }

    int getWeight() {
        return weight;
    }

    static Hand ofOpponentLabel(char opponentLabel) {
        return Arrays.stream(values())
                .filter(hand -> hand.getOpponentLabel() == opponentLabel)
                .findFirst()
                .orElseThrow();
    }

    static Hand ofEncryptedStrategyLabel(char strategyLabel) {
        return Arrays.stream(values())
                .filter(hand -> hand.getStrategyLabel() == strategyLabel)
                .findFirst()
                .orElseThrow();
    }

    static Hand ofStrategyOutcomeLabel(Hand opponentHand, char outcomeLabel) {
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
