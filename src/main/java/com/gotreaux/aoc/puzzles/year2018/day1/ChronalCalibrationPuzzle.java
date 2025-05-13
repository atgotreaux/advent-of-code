package com.gotreaux.aoc.puzzles.year2018.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class ChronalCalibrationPuzzle extends Puzzle {

    public ChronalCalibrationPuzzle() {
        super(2018, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        var resultingFrequency = Integer.MAX_VALUE;
        var firstDuplicateFrequency = Integer.MAX_VALUE;

        var format = new DecimalFormat();
        format.setPositivePrefix("+");

        var frequency = 0;
        Collection<Integer> reachedFrequencies = new ArrayList<>();
        reachedFrequencies.add(frequency);

        var frequencyPosition = 0;
        var frequencyChanges = inputReader.getInputList();
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
