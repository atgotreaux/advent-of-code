package com.gotreaux.aoc.puzzles.year2021.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class SonarSweepPuzzle extends Puzzle {

    public SonarSweepPuzzle() {
        super(2021, 1);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var measurements = inputReader.getInputStream().map(Integer::parseInt).toList();

        var measurementIncreaseCount =
                IntStream.range(1, measurements.size())
                        .filter(index -> measurements.get(index) > measurements.get(index - 1))
                        .count();

        var measurementWindowIncreaseCount =
                IntStream.range(0, measurements.size() - 3)
                        .filter(index -> measurements.get(index + 3) > measurements.get(index))
                        .count();

        return new PuzzleOutput<>(measurementIncreaseCount, measurementWindowIncreaseCount);
    }
}
