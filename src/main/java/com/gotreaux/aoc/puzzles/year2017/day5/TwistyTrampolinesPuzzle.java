package com.gotreaux.aoc.puzzles.year2017.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.function.IntFunction;
import org.springframework.stereotype.Component;

@Component
public class TwistyTrampolinesPuzzle extends Puzzle {

    public TwistyTrampolinesPuzzle() {
        super(2017, 5);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var input = inputReader.getInputStream().mapToInt(Integer::parseInt).toArray();

        var incrementedSteps = getStepsToExit(input, i -> i + 1);
        var strangerSteps = getStepsToExit(input, i -> i >= 3 ? i - 1 : i + 1);

        return new PuzzleOutput<>(incrementedSteps, strangerSteps);
    }

    private static int getStepsToExit(int[] input, IntFunction<Integer> adjustOffset) {
        var steps = 0;
        var position = 0;
        var length = input.length;
        var offsets = Arrays.copyOf(input, length);

        while (position >= 0 && position < length) {
            var offset = offsets[position];
            offsets[position] = adjustOffset.apply(offsets[position]);
            position += offset;
            steps++;
        }

        return steps;
    }
}
