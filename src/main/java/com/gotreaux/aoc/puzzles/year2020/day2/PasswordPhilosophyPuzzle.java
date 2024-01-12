package com.gotreaux.aoc.puzzles.year2020.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;

@ShellPuzzle(year = 2020, day = 2, title = "Password Philosophy")
public class PasswordPhilosophyPuzzle extends Puzzle {

    public PasswordPhilosophyPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int sumOfValidOccurrencesInRange = 0;
        int sumOfValidPositions = 0;

        for (String line : getInputProvider().getInputList()) {
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

            OccurrencePasswordPolicy rangePolicy =
                    new OccurrencePasswordPolicy(first, second, target);
            if (rangePolicy.passes(password)) {
                sumOfValidOccurrencesInRange++;
            }

            PositionPasswordPolicy positionPolicy =
                    new PositionPasswordPolicy(first, second, target);
            if (positionPolicy.passes(password)) {
                sumOfValidPositions++;
            }
        }

        return new PuzzleOutput<>(sumOfValidOccurrencesInRange, sumOfValidPositions);
    }
}
