package com.gotreaux.year2023.day1;

import com.gotreaux.Puzzle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TrebuchetPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        TrebuchetPuzzle puzzle = new TrebuchetPuzzle();

        puzzle.solve();
    }

    public TrebuchetPuzzle() {
        super();
    }

    public TrebuchetPuzzle(String fileName) {
        super(fileName);
    }

    @Override
    public Long getPartOne() throws Exception {
        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(line -> {
                String firstDigit = null;
                String lastDigit = null;
                for (Character c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        if (firstDigit == null) {
                            firstDigit = String.valueOf(c);
                        }
                        lastDigit = String.valueOf(c);
                    }
                }

                return Long.parseLong(firstDigit + lastDigit);
            }).sum();
        }
    }

    @Override
    public Long getPartTwo() throws Exception {
        List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        try (Stream<String> lines = getInputProvider().getInputStream()) {
            return lines.mapToLong(line -> {
                String firstDigit = null;
                String lastDigit = null;
                for (int i = 0; i < line.length(); i++) {
                    Character c = line.charAt(i);

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
            }).sum();
        }
    }
}
