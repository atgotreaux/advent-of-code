package com.gotreaux.year2023.day1;

import com.gotreaux.Puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TrebuchetPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        TrebuchetPuzzle puzzle = new TrebuchetPuzzle();

        puzzle.solve();
    }

    private long calibrationValue;
    private long calibrationValueWithDigits;

    public TrebuchetPuzzle() {
        super();
    }

    public TrebuchetPuzzle(String fileName) {
        super(fileName);
    }

    @Override
    public void prepare() throws Exception {
        List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            lines.forEach(line -> {
                List<String> calibrationValues = new ArrayList<>();
                List<String> calibrationValuesWithDigits = new ArrayList<>();

                int substringIndex = 0;
                for (Character c : line.toCharArray()) {
                    String substring = line.substring(substringIndex);
                    for (String word : words) {
                        if (substring.startsWith(word)) {
                            calibrationValuesWithDigits.add(String.valueOf(words.indexOf(word) + 1));
                            break;
                        }
                    }
                    if (Character.isDigit(c)) {
                        calibrationValues.add(String.valueOf(c));
                        calibrationValuesWithDigits.add(String.valueOf(c));
                    }
                    substringIndex++;
                }

                if (!calibrationValues.isEmpty()) {
                    calibrationValue += Integer.parseInt(calibrationValues.getFirst() + calibrationValues.getLast());
                }
                if (!calibrationValuesWithDigits.isEmpty()) {
                    calibrationValueWithDigits += Integer.parseInt(calibrationValuesWithDigits.getFirst() + calibrationValuesWithDigits.getLast());
                }
            });
        }
    }

    @Override
    public Long getPartOne() {
        return this.calibrationValue;
    }

    @Override
    public Long getPartTwo() {
        return this.calibrationValueWithDigits;
    }
}
