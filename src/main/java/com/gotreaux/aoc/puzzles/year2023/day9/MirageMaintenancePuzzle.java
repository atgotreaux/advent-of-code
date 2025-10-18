package com.gotreaux.aoc.puzzles.year2023.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class MirageMaintenancePuzzle extends Puzzle {

    public MirageMaintenancePuzzle() {
        super(2023, 9);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var histories = inputReader.getInputStream().map(History::of).toList();

        var sumOfForwardExtrapolation =
                histories.stream()
                        .mapToInt(history -> history.extrapolate(Direction.FORWARD))
                        .sum();

        var sumOfBackwardExtrapolation =
                histories.stream()
                        .mapToInt(history -> history.extrapolate(Direction.BACKWARD))
                        .sum();

        return new PuzzleOutput<>(sumOfForwardExtrapolation, sumOfBackwardExtrapolation);
    }
}
