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
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var sumOfValidOccurrencesInRange = 0;
        var sumOfValidPositions = 0;

        for (var line : inputReader.getInputList()) {
            var lineScanner = new Scanner(line);
            lineScanner.useDelimiter(": ");
            var passwordPolicyString = lineScanner.next();
            var password = lineScanner.next();
            lineScanner.close();

            var policyScanner = new Scanner(passwordPolicyString);
            var policyRange = policyScanner.next();
            var target = policyScanner.next().charAt(0);
            policyScanner.close();

            var policyRangeScanner = new Scanner(policyRange);
            policyRangeScanner.useDelimiter("-");
            var first = policyRangeScanner.nextInt();
            var second = policyRangeScanner.nextInt();
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
