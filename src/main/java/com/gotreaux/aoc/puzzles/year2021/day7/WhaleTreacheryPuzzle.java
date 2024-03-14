package com.gotreaux.aoc.puzzles.year2021.day7;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.MathUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

@ShellPuzzle(year = 2021, day = 7, title = "The Treachery of Whales")
public class WhaleTreacheryPuzzle extends Puzzle {
    public WhaleTreacheryPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NoSuchElementException {
        String input = getInputProvider().getInputString();

        List<Integer> positions = Arrays.stream(input.split(",")).map(Integer::parseInt).toList();

        int minPosition = positions.stream().min(Integer::compareTo).orElseThrow();
        int maxPosition = positions.stream().max(Integer::compareTo).orElseThrow();

        int linearAlignmentFuel =
                IntStream.rangeClosed(minPosition, maxPosition)
                        .map(i -> positions.stream().mapToInt(pos -> Math.abs(pos - i)).sum())
                        .min()
                        .orElseThrow();

        int consecutiveAlignmentFuel =
                IntStream.rangeClosed(minPosition, maxPosition)
                        .map(
                                i ->
                                        positions.stream()
                                                .mapToInt(
                                                        pos ->
                                                                MathUtils.consecutiveSum(
                                                                        Math.abs(pos - i)))
                                                .sum())
                        .min()
                        .orElseThrow();

        return new PuzzleOutput<>(linearAlignmentFuel, consecutiveAlignmentFuel);
    }
}
