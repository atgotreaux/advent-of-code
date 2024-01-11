package com.gotreaux.aoc.puzzles.year2022.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;

@ShellPuzzle(year = 2022, day = 2, title = "Rock Paper Scissors")
public class RockPaperScissorsPuzzle extends Puzzle {

    public RockPaperScissorsPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int encryptedStrategyScore = 0;
        int outcomeStrategyScore = 0;

        for (String line : getInputProvider().getInputList()) {
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
        }

        return new PuzzleOutput<>(encryptedStrategyScore, outcomeStrategyScore);
    }
}
