package com.gotreaux.aoc.puzzles.year2017.day1;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;

@ShellPuzzle(year = 2017, day = 1, title = "Inverse Captcha")
public class InverseCaptchaPuzzle extends Puzzle {

    public InverseCaptchaPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        int sumOfNextDigitsMatching = 0;
        int sumOfHalfwayDigitsMatching = 0;

        String input = getInputProvider().inputString();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            char nextChar = i + 1 == input.length() ? input.charAt(0) : input.charAt(i + 1);
            if (currentChar == nextChar) {
                sumOfNextDigitsMatching += Character.digit(currentChar, 10);
            }

            int halfwayIndex = i + (input.length() / 2);
            if (halfwayIndex >= input.length()) {
                halfwayIndex = halfwayIndex - input.length();
            }
            char halfwayChar = input.charAt(halfwayIndex);
            if (currentChar == halfwayChar) {
                sumOfHalfwayDigitsMatching += Character.digit(currentChar, 10);
            }
        }

        return new PuzzleOutput<>(sumOfNextDigitsMatching, sumOfHalfwayDigitsMatching);
    }
}
