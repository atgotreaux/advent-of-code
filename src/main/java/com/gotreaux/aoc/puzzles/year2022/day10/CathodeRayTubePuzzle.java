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
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var sumOfSignalStrengths =
                IntStream.rangeClosed(0, 5).map(i -> getSignalStrength(input, i * 40 + 20)).sum();

        return new PuzzleOutput<>(sumOfSignalStrengths, 0);
    }

    static int getSignalStrength(List<String> input, int cycles) {
        var wait = false;
        var instructionIndex = 0;
        var x = 1;

        for (var cycleIndex = 1; cycleIndex < cycles; cycleIndex++) {
            var instruction = input.get(instructionIndex);
            if ("noop".equals(instruction)) {
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
