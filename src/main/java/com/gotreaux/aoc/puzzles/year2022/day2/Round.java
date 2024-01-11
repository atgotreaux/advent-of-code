package com.gotreaux.aoc.puzzles.year2022.day2;

public record Round(Hand opponentHand, Hand strategyHand) {
    public int getScore() {
        if (opponentHand == strategyHand) {
            return 3;
        }

        if ((opponentHand == Hand.ROCK && strategyHand == Hand.PAPER)
                || (opponentHand == Hand.PAPER && strategyHand == Hand.SCISSORS)
                || (opponentHand == Hand.SCISSORS && strategyHand == Hand.ROCK)) {
            return 6;
        }

        return 0;
    }
}
