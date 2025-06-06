package com.gotreaux.aoc.puzzles.year2023.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TrebuchetPuzzle extends Puzzle {

    public TrebuchetPuzzle() {
        super(2023, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var calibrationValue = 0;
        var calibrationValueWithDigits = 0;

        var digitWords =
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        for (var line : inputReader.getInputList()) {
            var calibrationValues = new StringBuilder(line.length());
            var calibrationValuesWithDigits = new StringBuilder(line.length());

            for (var i = 0; i < line.length(); i++) {
                var substring = line.substring(i);
                for (var j = 0; j < digitWords.size(); j++) {
                    if (substring.startsWith(digitWords.get(j))) {
                        calibrationValuesWithDigits.append(j + 1);
                        break;
                    }
                }
                var c = line.charAt(i);
                if (Character.isDigit(c)) {
                    calibrationValues.append(c);
                    calibrationValuesWithDigits.append(c);
                }
            }

            if (!calibrationValues.isEmpty()) {
                calibrationValue += extractCalibrationValue(calibrationValues);
            }
            if (!calibrationValuesWithDigits.isEmpty()) {
                calibrationValueWithDigits += extractCalibrationValue(calibrationValuesWithDigits);
            }
        }

        return new PuzzleOutput<>(calibrationValue, calibrationValueWithDigits);
    }

    private static int extractCalibrationValue(CharSequence sequence) {
        return 10 * Character.digit(sequence.charAt(0), 10)
                + Character.digit(sequence.charAt(sequence.length() - 1), 10);
    }
}
