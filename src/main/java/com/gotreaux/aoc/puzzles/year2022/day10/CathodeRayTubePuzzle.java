package com.gotreaux.aoc.puzzles.year2022.day10;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class CathodeRayTubePuzzle extends Puzzle {

    public CathodeRayTubePuzzle() {
        super(2022, 10);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        List<String> input = inputReader.getInputList();

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
