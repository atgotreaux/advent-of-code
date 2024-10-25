package com.gotreaux.aoc.puzzles.year2020.day2;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class PasswordPhilosophyPuzzle extends Puzzle {

    public PasswordPhilosophyPuzzle() {
        super(2020, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException {
        int sumOfValidOccurrencesInRange = 0;
        int sumOfValidPositions = 0;

        for (String line : inputProvider.getInputList()) {
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(": ");
            String passwordPolicyString = lineScanner.next();
            String password = lineScanner.next();
            lineScanner.close();

            Scanner policyScanner = new Scanner(passwordPolicyString);
            String policyRange = policyScanner.next();
            char target = policyScanner.next().charAt(0);
            policyScanner.close();

            Scanner policyRangeScanner = new Scanner(policyRange);
            policyRangeScanner.useDelimiter("-");
            int first = policyRangeScanner.nextInt();
            int second = policyRangeScanner.nextInt();
            policyRangeScanner.close();

            PasswordPolicy rangePolicy = new OccurrencePasswordPolicy(first, second, target);
            if (rangePolicy.passes(password)) {
                sumOfValidOccurrencesInRange++;
            }

            PasswordPolicy positionPolicy = new PositionPasswordPolicy(first, second, target);
            if (positionPolicy.passes(password)) {
                sumOfValidPositions++;
            }
        }

        return new PuzzleOutput<>(sumOfValidOccurrencesInRange, sumOfValidPositions);
    }
}
