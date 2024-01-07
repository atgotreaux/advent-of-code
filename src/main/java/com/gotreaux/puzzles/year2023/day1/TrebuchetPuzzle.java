package com.gotreaux.puzzles.year2023.day1;

import com.gotreaux.annotations.ShellPuzzle;
import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@ShellPuzzle(year = 2023, day = 1, title = "Trebuchet?!")
public class TrebuchetPuzzle extends Puzzle {

    public TrebuchetPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(
                            line -> {
                                String firstDigit = null;
                                String lastDigit = null;
                                for (int i = 0; i < line.length(); i++) {
                                    char c = line.charAt(i);
                                    if (Character.isDigit(c)) {
                                        if (firstDigit == null) {
                                            firstDigit = String.valueOf(c);
                                        }
                                        lastDigit = String.valueOf(c);
                                    }
                                }

                                return Long.parseLong(firstDigit + lastDigit);
                            })
                    .sum();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        List<String> words =
                Arrays.asList(
                        "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(
                            line -> {
                                String firstDigit = null;
                                String lastDigit = null;
                                for (int i = 0; i < line.length(); i++) {
                                    char c = line.charAt(i);

                                    String subString = line.substring(i);
                                    for (String word : words) {
                                        if (subString.startsWith(word)) {
                                            c = String.valueOf(words.indexOf(word) + 1).charAt(0);
                                            break;
                                        }
                                    }

                                    if (Character.isDigit(c)) {
                                        if (firstDigit == null) {
                                            firstDigit = String.valueOf(c);
                                        }
                                        lastDigit = String.valueOf(c);
                                    }
                                }

                                return Long.parseLong(firstDigit + lastDigit);
                            })
                    .sum();
        }
    }
}
