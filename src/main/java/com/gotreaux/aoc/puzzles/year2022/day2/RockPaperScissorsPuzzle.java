package com.gotreaux.aoc.puzzles.year2022.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class RockPaperScissorsPuzzle extends Puzzle {

    public RockPaperScissorsPuzzle() {
        super(2022, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException, NoSuchElementException {
        int encryptedStrategyScore = 0;
        int outcomeStrategyScore = 0;

        for (String line : inputReader.getInputList()) {
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
