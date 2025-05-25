package com.gotreaux.aoc.puzzles.year2018.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class ChronalCalibrationPuzzle extends Puzzle {

    public ChronalCalibrationPuzzle() {
        super(2018, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var resultingFrequency = Integer.MAX_VALUE;
        var firstDuplicateFrequency = Integer.MAX_VALUE;

        var frequency = 0;
        Collection<Integer> reachedFrequencies = new ArrayList<>();
        reachedFrequencies.add(frequency);

        var frequencyPosition = 0;
        var frequencyChanges = inputReader.getInputList();
        while (firstDuplicateFrequency == Integer.MAX_VALUE) {
            frequency += Integer.parseInt(frequencyChanges.get(frequencyPosition));

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
