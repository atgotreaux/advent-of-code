package com.gotreaux.year2021.day1;

import com.gotreaux.Puzzle;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SonarSweepPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        SonarSweepPuzzle puzzle = new SonarSweepPuzzle();

        puzzle.solve();
    }

    private List<Long> depthMeasurements;

    @Override
    public void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            depthMeasurements = lines.map(Long::parseLong).toList();
        }
    }

    @Override
    public Long getPartOne() {
        return getMeasurementIncreaseCount(depthMeasurements);
    }

    @Override
    public Long getPartTwo() {
        List<Long> windows = IntStream.range(0, depthMeasurements.size() - 3 + 1)
                .mapToObj(windowStart -> depthMeasurements.subList(windowStart, windowStart + 3))
                .flatMapToLong(longs -> LongStream.of(longs.stream().reduce(0L, Long::sum)))
                .boxed()
                .toList();

        return getMeasurementIncreaseCount(windows);
    }

    private long getMeasurementIncreaseCount(List<Long> measurements) {
        return IntStream.range(1, measurements.size())
                .filter(index -> measurements.get(index) > measurements.get(index - 1))
                .count();
    }
}
