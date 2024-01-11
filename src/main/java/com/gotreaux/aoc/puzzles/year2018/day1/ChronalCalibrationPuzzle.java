package com.gotreaux.aoc.puzzles.year2018.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@ShellPuzzle(year = 2018, day = 1, title = "Chronal Calibration")
public class ChronalCalibrationPuzzle extends Puzzle {

    public ChronalCalibrationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws Exception {
        return new PuzzleOutput<>(getPartOne(), getPartTwo());
    }

    public Long getPartOne() throws Exception {
        DecimalFormat format = new DecimalFormat();
        format.setPositivePrefix("+");

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(
                            line -> {
                                try {
                                    return format.parse(line).longValue();
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }
                            })
                    .sum();
        }
    }

    public Long getPartTwo() throws Exception {
        DecimalFormat format = new DecimalFormat();
        format.setPositivePrefix("+");

        List<String> frequencyChanges = getInputProvider().getInputList();

        long currentFrequency = 0;
        List<Long> reachedFrequencies = new ArrayList<>();
        reachedFrequencies.add(currentFrequency);

        int currentFrequencyPosition = 0;
        while (true) {
            currentFrequency +=
                    format.parse(frequencyChanges.get(currentFrequencyPosition)).longValue();
            if (reachedFrequencies.contains(currentFrequency)) {
                return currentFrequency;
            }
            reachedFrequencies.add(currentFrequency);

            currentFrequencyPosition++;
            if (currentFrequencyPosition == frequencyChanges.size()) {
                currentFrequencyPosition = 0;
            }
        }
    }
}
