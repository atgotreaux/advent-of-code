package com.gotreaux.aoc.puzzles.year2022.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class RockPaperScissorsPuzzle extends Puzzle {

    public RockPaperScissorsPuzzle() {
        super(2022, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var encryptedStrategyScore = 0;
        var outcomeStrategyScore = 0;

        for (var line : inputReader.getInputList()) {
            var scanner = new Scanner(line);
            var opponentLabel = scanner.next().charAt(0);
            var strategyLabel = scanner.next().charAt(0);
            scanner.close();

            var opponentHand = Hand.ofOpponentLabel(opponentLabel);
            var encryptedStrategyHand = Hand.ofEncryptedStrategyLabel(strategyLabel);
            var outcomeStrategyHand = Hand.ofStrategyOutcomeLabel(opponentHand, strategyLabel);

            var encryptedRound = new Round(opponentHand, encryptedStrategyHand);
            var outcomeRound = new Round(opponentHand, outcomeStrategyHand);

            encryptedStrategyScore += encryptedRound.getScore() + encryptedStrategyHand.getWeight();
            outcomeStrategyScore += outcomeRound.getScore() + outcomeStrategyHand.getWeight();
        }

        return new PuzzleOutput<>(encryptedStrategyScore, outcomeStrategyScore);
    }
}
