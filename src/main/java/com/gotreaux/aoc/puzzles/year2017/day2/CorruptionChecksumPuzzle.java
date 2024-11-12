package com.gotreaux.aoc.puzzles.year2017.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
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
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException {
        int sumOfLargestDifferences = 0;
        int sumOfLargestDivisibility = 0;

        for (String line : inputReader.getInputList()) {
            Collection<Integer> numbers = new ArrayList<>();
            int largest = Integer.MIN_VALUE;
            int smallest = Integer.MAX_VALUE;

            Scanner scanner = new Scanner(line);
            while (scanner.hasNextLong()) {
                int number = scanner.nextInt();

                largest = Math.max(largest, number);
                smallest = Math.min(smallest, number);

                for (int previousNumber : numbers) {
                    int larger = Math.max(previousNumber, number);
                    int smaller = Math.min(previousNumber, number);
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
