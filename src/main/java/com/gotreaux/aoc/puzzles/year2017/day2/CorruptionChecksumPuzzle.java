package com.gotreaux.aoc.puzzles.year2017.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Stream;

@ShellPuzzle(year = 2017, day = 2, title = "Corruption Checksum")
public class CorruptionChecksumPuzzle extends Puzzle {

    public CorruptionChecksumPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

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

    public Long getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(
                            line -> {
                                Collection<Long> numbers = new ArrayList<>();

                                Scanner scanner = new Scanner(line);
                                while (scanner.hasNextLong()) {
                                    long number = scanner.nextLong();
                                    for (long previousNumber : numbers) {
                                        long larger = Math.max(previousNumber, number);
                                        long smaller = Math.min(previousNumber, number);
                                        if (larger % smaller == 0L) {
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
