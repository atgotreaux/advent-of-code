package com.gotreaux.aoc.puzzles.year2022.day2;

record Round(Hand opponentHand, Hand strategyHand) {
    int getScore() {
        var score = 0;

        if (opponentHand == strategyHand) {
            score = 3;
        }

        if (Hand.ofStrategyOutcomeLabel(opponentHand, 'Z') == strategyHand) {
            score = 6;
        }

        return score;
    }
}
