package com.gotreaux.aoc.puzzles.year2020.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.stereotype.Component;

@Component
public class HandheldHaltingPuzzle extends Puzzle {

    public HandheldHaltingPuzzle() {
        super(2020, 8);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var instructions = inputReader.getInputStream().map(Instruction::of).toList();

        var accumulator = 0;
        var instructionIndex = 0;
        Collection<Integer> visitedInstructions = new HashSet<>(instructions.size());
        while (visitedInstructions.add(instructionIndex)) {
            var instruction = instructions.get(instructionIndex);
            switch (instruction.operation()) {
                case ACC -> {
                    accumulator += instruction.argument();
                    instructionIndex++;
                }
                case JMP -> instructionIndex += instruction.argument();
                case NOP -> instructionIndex++;
            }
        }

        return new PuzzleOutput<>(accumulator, 0);
    }
}
