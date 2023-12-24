package com.gotreaux.year2022.day1;

import com.gotreaux.Puzzle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class CalorieCountingPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        CalorieCountingPuzzle puzzle = new CalorieCountingPuzzle();

        puzzle.solve();
    }

    public CalorieCountingPuzzle() throws Exception {
        super();

        prepare();
    }

    private final Map<Long, Long> elfCalorieCarriage = new HashMap<>();

    private void prepare() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            AtomicLong currentElfIndex = new AtomicLong();
            lines.forEach(line -> {
                if (line.isBlank()) {
                    currentElfIndex.getAndIncrement();
                } else {
                    long calories = Long.parseLong(line);
                    elfCalorieCarriage.merge(currentElfIndex.get(), calories, Long::sum);
                }
            });
        }
    }

    @Override
    public Long getPartOne() throws NoSuchElementException {
        return elfCalorieCarriage.values()
                .stream()
                .max(Long::compare)
                .orElseThrow();
    }

    @Override
    public Long getPartTwo() {
        return elfCalorieCarriage.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(0L, Long::sum);
    }
}
