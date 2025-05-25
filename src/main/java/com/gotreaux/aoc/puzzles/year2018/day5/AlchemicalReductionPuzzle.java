package com.gotreaux.aoc.puzzles.year2018.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class AlchemicalReductionPuzzle extends Puzzle {

    public AlchemicalReductionPuzzle() {
        super(2018, 5);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputString();

        var collapsedPolymer = collapse(input);

        int shortestCollapsedPolymer =
                input.chars()
                        .map(Character::toLowerCase)
                        .distinct()
                        .mapToObj(
                                i ->
                                        input.replace(Character.toString(i), "")
                                                .replace(
                                                        Character.toString(
                                                                Character.toUpperCase(i)),
                                                        ""))
                        .map(AlchemicalReductionPuzzle::collapse)
                        .map(String::length)
                        .min(Integer::compareTo)
                        .orElseThrow();

        return new PuzzleOutput<>(collapsedPolymer.length(), shortestCollapsedPolymer);
    }

    private static String collapse(String input) {
        var result = new StringBuilder(input.length());
        for (var i = 0; i < input.length(); i++) {
            var x = input.codePointAt(i);
            if (i < input.length() - 1
                    && x != input.codePointAt(i + 1)
                    && Character.toLowerCase(x)
                            == Character.toLowerCase(input.codePointAt(i + 1))) {
                i++;
            } else {
                result.appendCodePoint(x);
            }
        }

        if (result.length() == input.length()) {
            return input;
        }
        return collapse(result.toString());
    }
}
