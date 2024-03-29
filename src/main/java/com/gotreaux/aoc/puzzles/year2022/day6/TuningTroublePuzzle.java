package com.gotreaux.aoc.puzzles.year2022.day6;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.IntStream;

@ShellPuzzle(year = 2022, day = 6, title = "Tuning Trouble")
public class TuningTroublePuzzle extends Puzzle {
    public TuningTroublePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        String input = getInputProvider().getInputString();

        int startOfPacketMarker =
                IntStream.range(4, input.length())
                        .filter(i -> input.substring(i - 4, i).chars().distinct().count() == 4L)
                        .findFirst()
                        .orElse(Integer.MAX_VALUE);

        int startOfMessageMarket =
                IntStream.range(14, input.length())
                        .filter(i -> input.substring(i - 14, i).chars().distinct().count() == 14L)
                        .findFirst()
                        .orElse(Integer.MAX_VALUE);

        return new PuzzleOutput<>(startOfPacketMarker, startOfMessageMarket);
    }
}
