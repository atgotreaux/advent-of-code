package com.gotreaux.aoc.puzzles.year2022.day10;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.IntStream;

@ShellPuzzle(year = 2022, day = 10, title = "Cathode-Ray Tube")
public class CathodeRayTubePuzzle extends Puzzle {
    public CathodeRayTubePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        List<String> input = getInputProvider().getInputList();

        int sumOfSignalStrengths =
                IntStream.rangeClosed(0, 5).map(i -> getSignalStrength(input, i * 40 + 20)).sum();

        return new PuzzleOutput<>(sumOfSignalStrengths, 0);
    }

    static int getSignalStrength(List<String> input, int cycles) {
        boolean wait = false;
        int instructionIndex = 0;
        int x = 1;

        for (int cycleIndex = 1; cycleIndex < cycles; cycleIndex++) {
            String instruction = input.get(instructionIndex);
            if (instruction.equals("noop")) {
                instructionIndex++;
            } else if (instruction.startsWith("addx")) {
                if (wait) {
                    x += Integer.parseInt(instruction.substring(5));
                    instructionIndex++;
                }
                wait = !wait;
            }
        }

        return x * cycles;
    }
}
