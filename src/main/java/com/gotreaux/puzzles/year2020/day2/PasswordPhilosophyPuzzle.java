package com.gotreaux.puzzles.year2020.day2;

import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;
import java.util.Scanner;
import java.util.stream.Stream;

public class PasswordPhilosophyPuzzle extends Puzzle {

    public PasswordPhilosophyPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.filter(
                            line -> {
                                Scanner lineScanner = new Scanner(line);
                                lineScanner.useDelimiter(": ");
                                String passwordPolicyString = lineScanner.next();
                                String password = lineScanner.next();
                                lineScanner.close();

                                Scanner policyScanner = new Scanner(passwordPolicyString);
                                String policyRange = policyScanner.next();
                                String targetString = policyScanner.next();

                                Scanner policyRangeScanner = new Scanner(policyRange);
                                policyRangeScanner.useDelimiter("-");
                                long min = policyRangeScanner.nextLong();
                                long max = policyRangeScanner.nextLong();

                                OccurrenceRangePasswordPolicy passwordPolicy =
                                        new OccurrenceRangePasswordPolicy(
                                                min, max, targetString.charAt(0));
                                return passwordPolicy.passes(password);
                            })
                    .count();
        }
    }

    @Override
    public Object getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.filter(
                            line -> {
                                Scanner lineScanner = new Scanner(line);
                                lineScanner.useDelimiter(": ");
                                String passwordPolicyString = lineScanner.next();
                                String password = lineScanner.next();
                                lineScanner.close();

                                Scanner policyScanner = new Scanner(passwordPolicyString);
                                String policyRange = policyScanner.next();
                                String targetString = policyScanner.next();

                                Scanner policyRangeScanner = new Scanner(policyRange);
                                policyRangeScanner.useDelimiter("-");
                                long first = policyRangeScanner.nextLong();
                                long second = policyRangeScanner.nextLong();

                                PositionPasswordPolicy passwordPolicy =
                                        new PositionPasswordPolicy(
                                                first, second, targetString.charAt(0));
                                return passwordPolicy.passes(password);
                            })
                    .count();
        }
    }
}
