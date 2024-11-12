package com.gotreaux.aoc.puzzles.year2017.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.function.IntFunction;
import org.springframework.stereotype.Component;

@Component
public class TwistyTrampolinesPuzzle extends Puzzle {

    public TwistyTrampolinesPuzzle() {
        super(2017, 5);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException {
        int[] input = inputReader.getInputStream().mapToInt(Integer::parseInt).toArray();

        int incrementedSteps = getStepsToExit(input, i -> i + 1);
        int strangerSteps = getStepsToExit(input, i -> i >= 3 ? i - 1 : i + 1);

        return new PuzzleOutput<>(incrementedSteps, strangerSteps);
    }

    private static int getStepsToExit(int[] input, IntFunction<Integer> adjustOffset) {
        int steps = 0;
        int position = 0;
        int length = input.length;
        int[] offsets = Arrays.copyOf(input, length);

        while (position >= 0 && position < length) {
            int offset = offsets[position];
            offsets[position] = adjustOffset.apply(offsets[position]);
            position += offset;
            steps++;
        }

        return steps;
    }
}
