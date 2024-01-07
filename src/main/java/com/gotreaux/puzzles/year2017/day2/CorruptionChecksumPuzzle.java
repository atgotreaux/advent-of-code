package com.gotreaux.puzzles.year2017.day2;

import com.gotreaux.annotations.ShellPuzzle;
import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2017, day = 2, title = "Corruption Checksum")
public class CorruptionChecksumPuzzle extends Puzzle {

    public CorruptionChecksumPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(
                            line -> {
                                long largest = Long.MIN_VALUE;
                                long smallest = Long.MAX_VALUE;

                                Scanner scanner = new Scanner(line);
                                while (scanner.hasNextLong()) {
                                    long number = scanner.nextLong();
                                    largest = Math.max(largest, number);
                                    smallest = Math.min(smallest, number);
                                }
                                scanner.close();

                                return largest - smallest;
                            })
                    .sum();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(
                            line -> {
                                List<Long> numbers = new ArrayList<>();

                                Scanner scanner = new Scanner(line);
                                while (scanner.hasNextLong()) {
                                    long number = scanner.nextLong();
                                    for (long previousNumber : numbers) {
                                        long larger = Math.max(previousNumber, number);
                                        long smaller = Math.min(previousNumber, number);
                                        if (larger % smaller == 0) {
                                            return larger / smaller;
                                        }
                                    }
                                    numbers.add(number);
                                }
                                scanner.close();

                                throw new RuntimeException(
                                        "No divisible numbers in line '%s'".formatted(line));
                            })
                    .sum();
        }
    }
}
