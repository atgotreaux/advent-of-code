package com.gotreaux.aoc.puzzles.year2021.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.MathUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class WhaleTreacheryPuzzle extends Puzzle {

    public WhaleTreacheryPuzzle() {
        super(2021, 7);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        String input = inputReader.getInputString();

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
