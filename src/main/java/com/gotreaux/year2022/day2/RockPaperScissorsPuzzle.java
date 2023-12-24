package com.gotreaux.year2022.day2;

import com.gotreaux.Puzzle;

import java.util.Scanner;
import java.util.stream.Stream;

public class RockPaperScissorsPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        puzzle.solve();
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(line -> {
                Scanner scanner = new Scanner(line);
                char opponentLabel = scanner.next().charAt(0);
                char strategyLabel = scanner.next().charAt(0);
                scanner.close();

                Hand opponentHand = Hand.fromOpponentLabel(opponentLabel);
                Hand encryptedStrategyHand = Hand.fromEncryptedStrategyLabel(strategyLabel);

                Round encryptedRound = new Round(opponentHand, encryptedStrategyHand);

                return encryptedRound.getScore() + encryptedStrategyHand.getWeight();
            }).sum();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(line -> {
                Scanner scanner = new Scanner(line);
                char opponentLabel = scanner.next().charAt(0);
                char strategyLabel = scanner.next().charAt(0);
                scanner.close();

                Hand opponentHand = Hand.fromOpponentLabel(opponentLabel);
                Hand outcomeStrategyHand = Hand.fromStrategyOutcomeLabel(opponentHand, strategyLabel);

                Round outcomeRound = new Round(opponentHand, outcomeStrategyHand);

                return outcomeRound.getScore() + outcomeStrategyHand.getWeight();
            }).sum();
        }
    }
}
