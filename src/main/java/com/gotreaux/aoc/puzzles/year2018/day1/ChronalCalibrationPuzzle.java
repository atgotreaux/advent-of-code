package com.gotreaux.aoc.puzzles.year2018.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ShellPuzzle(year = 2018, day = 1, title = "Chronal Calibration")
public class ChronalCalibrationPuzzle extends Puzzle {

    public ChronalCalibrationPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int resultingFrequency = Integer.MAX_VALUE;
        int firstDuplicateFrequency = Integer.MAX_VALUE;

        DecimalFormat format = new DecimalFormat();
        format.setPositivePrefix("+");

        int frequency = 0;
        Collection<Integer> reachedFrequencies = new ArrayList<>();
        reachedFrequencies.add(frequency);

        int frequencyPosition = 0;
        List<String> frequencyChanges = getInputProvider().getInputList();
        while (firstDuplicateFrequency == Integer.MAX_VALUE) {
            frequency += format.parse(frequencyChanges.get(frequencyPosition)).intValue();

            if (reachedFrequencies.contains(frequency)) {
                firstDuplicateFrequency = frequency;
            }
            reachedFrequencies.add(frequency);

            frequencyPosition++;
            if (frequencyPosition == frequencyChanges.size()) {
                if (resultingFrequency == Integer.MAX_VALUE) {
                    resultingFrequency = frequency;
                }
                frequencyPosition = 0;
            }
        }

        return new PuzzleOutput<>(resultingFrequency, firstDuplicateFrequency);
    }
}
