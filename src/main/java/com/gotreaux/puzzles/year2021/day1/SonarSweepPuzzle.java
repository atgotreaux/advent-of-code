package com.gotreaux.puzzles.year2021.day1;

import com.gotreaux.annotations.ShellPuzzle;
import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@ShellPuzzle(year = 2021, day = 1, title = "Sonar Sweep")
public class SonarSweepPuzzle extends Puzzle {

    public SonarSweepPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            List<Long> depthMeasurements = lines.map(Long::parseLong).toList();

            return getMeasurementIncreaseCount(depthMeasurements);
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            List<Long> depthMeasurements = lines.map(Long::parseLong).toList();

            List<Long> windows =
                    IntStream.range(0, depthMeasurements.size() - 3 + 1)
                            .mapToObj(
                                    windowStart ->
                                            depthMeasurements.subList(windowStart, windowStart + 3))
                            .flatMapToLong(
                                    longs -> LongStream.of(longs.stream().reduce(0L, Long::sum)))
                            .boxed()
                            .toList();

            return getMeasurementIncreaseCount(windows);
        }
    }

    private long getMeasurementIncreaseCount(List<Long> measurements) {
        return IntStream.range(1, measurements.size())
                .filter(index -> measurements.get(index) > measurements.get(index - 1))
                .count();
    }
}
