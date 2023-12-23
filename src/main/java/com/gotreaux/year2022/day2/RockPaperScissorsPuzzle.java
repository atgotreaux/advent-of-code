package com.gotreaux.year2022.day2;

import com.gotreaux.Puzzle;

import java.util.Scanner;
import java.util.stream.Stream;

public class RockPaperScissorsPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        RockPaperScissorsPuzzle puzzle = new RockPaperScissorsPuzzle();

        puzzle.solve();
    }

    private long encryptedStrategyScore;
    private long outcomeStrategyScore;

    @Override
    public void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                Scanner scanner = new Scanner(line);
                char opponentLabel = scanner.next().charAt(0);
                char strategyLabel = scanner.next().charAt(0);
                scanner.close();

                Hand opponentHand = Hand.fromOpponentLabel(opponentLabel);
                Hand encryptedStrategyHand = Hand.fromEncryptedStrategyLabel(strategyLabel);
                Hand outcomeStrategyHand = Hand.fromStrategyOutcomeLabel(opponentHand, strategyLabel);

                Round encryptedRound = new Round(opponentHand, encryptedStrategyHand);
                Round outcomeRound = new Round(opponentHand, outcomeStrategyHand);

                encryptedStrategyScore += encryptedRound.getScore() + encryptedStrategyHand.getWeight();
                outcomeStrategyScore += outcomeRound.getScore() + outcomeStrategyHand.getWeight();
            });
        }
    }

    @Override
    public Long getPartOne() {
        return encryptedStrategyScore;
    }

    @Override
    public Long getPartTwo() {
        return outcomeStrategyScore;
    }
}
