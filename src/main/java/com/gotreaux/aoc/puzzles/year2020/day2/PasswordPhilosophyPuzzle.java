package com.gotreaux.aoc.puzzles.year2020.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class PasswordPhilosophyPuzzle extends Puzzle {

    public PasswordPhilosophyPuzzle() {
        super(2020, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        int sumOfValidOccurrencesInRange = 0;
        int sumOfValidPositions = 0;

        for (String line : inputReader.getInputList()) {
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
