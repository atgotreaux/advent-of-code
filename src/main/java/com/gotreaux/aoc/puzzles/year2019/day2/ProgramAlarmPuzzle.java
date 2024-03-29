package com.gotreaux.aoc.puzzles.year2019.day2;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

@ShellPuzzle(year = 2019, day = 2, title = "1202 Program Alarm")
public class ProgramAlarmPuzzle extends Puzzle {
    private static final int COMPLETE_GRAVITY_ASSIST = 19690720;

    public ProgramAlarmPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, IllegalArgumentException {
        String input = getInputProvider().getInputString();

        int[] program = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        int length = program.length;

        IntcodeProgram restoreProgram = new IntcodeProgram(12, 2);
        int restoreGravity = restoreProgram.process(Arrays.copyOf(program, length));

        int completeGravity = Integer.MAX_VALUE;
        for (int i = 0; i < 100 && completeGravity == Integer.MAX_VALUE; i++) {
            for (int j = 0; j < 100; j++) {
                IntcodeProgram completeProgram = new IntcodeProgram(i, j);
                int[] programCopy = Arrays.copyOf(program, length);
                if (completeProgram.process(programCopy) == COMPLETE_GRAVITY_ASSIST) {
                    completeGravity = 100 * i + j;
                }
            }
        }

        return new PuzzleOutput<>(restoreGravity, completeGravity);
    }
}
