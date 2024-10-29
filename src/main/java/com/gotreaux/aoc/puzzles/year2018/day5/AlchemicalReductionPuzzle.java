package com.gotreaux.aoc.puzzles.year2018.day5;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.stereotype.Component;

@Component
public class AlchemicalReductionPuzzle extends Puzzle {

    public AlchemicalReductionPuzzle() {
        super(2018, 5);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException {
        String input = inputProvider.getInputString();

        String collapsedPolymer = collapse(input);

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
        StringBuilder result = new StringBuilder(input.length());
        for (int i = 0; i < input.length(); i++) {
            int x = input.codePointAt(i);
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