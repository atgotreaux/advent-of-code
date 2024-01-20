package com.gotreaux.aoc.puzzles.year2021.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ShellPuzzle(year = 2021, day = 1, title = "Sonar Sweep")
public class SonarSweepPuzzle extends Puzzle {

    public SonarSweepPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws IOException, URISyntaxException {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            List<Integer> measurements = lines.map(Integer::parseInt).toList();

            List<Integer> windows =
                    IntStream.range(0, measurements.size() - 3 + 1)
                            .mapToObj(window -> measurements.subList(window, window + 3))
                            .flatMapToInt(w -> IntStream.of(w.stream().reduce(0, Integer::sum)))
                            .boxed()
                            .toList();

            long measurementIncreaseCount = getMeasurementIncreaseCount(measurements);
            long measurementWindowIncreaseCount = getMeasurementIncreaseCount(windows);

            return new PuzzleOutput<>(measurementIncreaseCount, measurementWindowIncreaseCount);
        }
    }

    private static long getMeasurementIncreaseCount(List<Integer> measurements) {
        return IntStream.range(1, measurements.size())
                .filter(index -> measurements.get(index) > measurements.get(index - 1))
                .count();
    }
}
