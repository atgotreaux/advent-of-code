package com.gotreaux.aoc.puzzles.year2019.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class ProgramAlarmPuzzle extends Puzzle {
    private static final int COMPLETE_GRAVITY_ASSIST = 19690720;

    public ProgramAlarmPuzzle() {
        super(2019, 2);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputString();

        var program = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        var length = program.length;

        var restoreProgram = new IntcodeProgram(12, 2);
        var restoreGravity = restoreProgram.process(Arrays.copyOf(program, length));

        var completeGravity = Integer.MAX_VALUE;
        for (var i = 0; i < 100 && completeGravity == Integer.MAX_VALUE; i++) {
            for (var j = 0; j < 100; j++) {
                var completeProgram = new IntcodeProgram(i, j);
                var programCopy = Arrays.copyOf(program, length);
                if (completeProgram.process(programCopy) == COMPLETE_GRAVITY_ASSIST) {
                    completeGravity = 100 * i + j;
                }
            }
        }

        return new PuzzleOutput<>(restoreGravity, completeGravity);
    }
}
