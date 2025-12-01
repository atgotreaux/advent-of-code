package com.gotreaux.aoc.puzzles.year2025.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class SecretEntrancePuzzle extends Puzzle {

    private static final int STARTING_POSITION = 50;
    static final int DIAL_SIZE = 100;

    public SecretEntrancePuzzle() {
        super(2025, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var instructions = inputReader.getInputStream().map(Instruction::of).toList();

        var dial = STARTING_POSITION;
        var timesDialIsZero = 0;
        var timesDialPassesZero = 0;
        for (var instruction : instructions) {
            timesDialPassesZero += instruction.countZeroes(dial, DIAL_SIZE);
            dial = instruction.rotate(dial, DIAL_SIZE);
            if (dial == 0) {
                timesDialIsZero++;
            }
        }

        return new PuzzleOutput<>(timesDialIsZero, timesDialPassesZero);
    }
}
