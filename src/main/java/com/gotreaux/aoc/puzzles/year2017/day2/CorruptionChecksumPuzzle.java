package com.gotreaux.aoc.puzzles.year2017.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class CorruptionChecksumPuzzle extends Puzzle {

    public CorruptionChecksumPuzzle() {
        super(2017, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var sumOfLargestDifferences = 0;
        var sumOfLargestDivisibility = 0;

        for (var line : inputReader.getInputList()) {
            Collection<Integer> numbers = new ArrayList<>();
            var largest = Integer.MIN_VALUE;
            var smallest = Integer.MAX_VALUE;

            var scanner = new Scanner(line);
            while (scanner.hasNextLong()) {
                var number = scanner.nextInt();

                largest = Math.max(largest, number);
                smallest = Math.min(smallest, number);

                for (int previousNumber : numbers) {
                    var larger = Math.max(previousNumber, number);
                    var smaller = Math.min(previousNumber, number);
                    if (larger % smaller == 0) {
                        sumOfLargestDivisibility += larger / smaller;
                    }
                }
                numbers.add(number);
            }
            scanner.close();

            sumOfLargestDifferences += largest - smallest;
        }

        return new PuzzleOutput<>(sumOfLargestDifferences, sumOfLargestDivisibility);
    }
}
