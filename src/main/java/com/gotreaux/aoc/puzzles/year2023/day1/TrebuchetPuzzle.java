package com.gotreaux.aoc.puzzles.year2023.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;

@ShellPuzzle(year = 2023, day = 1, title = "Trebuchet?!")
public class TrebuchetPuzzle extends Puzzle {

    public TrebuchetPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws Exception {
        int calibrationValue = 0;
        int calibrationValueWithDigits = 0;

        List<String> digitWords =
                List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        for (String line : getInputProvider().getInputList()) {
            StringBuilder calibrationValues = new StringBuilder();
            StringBuilder calibrationValuesWithDigits = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                String substring = line.substring(i);
                for (int j = 0; j < digitWords.size(); j++) {
                    if (substring.startsWith(digitWords.get(j))) {
                        calibrationValuesWithDigits.append(j + 1);
                        break;
                    }
                }
                char c = line.charAt(i);
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
