package com.gotreaux.puzzles.year2017.day1;

import com.gotreaux.annotations.ShellPuzzle;
import com.gotreaux.input.InputProvider;
import com.gotreaux.puzzles.Puzzle;

@ShellPuzzle(year = 2017, day = 1, title = "Inverse Captcha")
public class InverseCaptchaPuzzle extends Puzzle {

    public InverseCaptchaPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public Long getPartOne() throws Exception {
        long sumOfNextDigitsMatching = 0L;

        String input = getInputProvider().getInputString();
        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            int nextIndex = index + 1;
            if (nextIndex == input.length()) {
                nextIndex = 0;
            }
            char nextChar = input.charAt(nextIndex);

            if (currentChar == nextChar) {
                sumOfNextDigitsMatching += Long.parseLong(String.valueOf(currentChar));
            }
        }

        return sumOfNextDigitsMatching;
    }

    @Override
    public Long getPartTwo() throws Exception {
        long sumOfHalfwayDigitsMatching = 0L;

        String input = getInputProvider().getInputString();
        for (int index = 0; index < input.length(); index++) {
            char currentChar = input.charAt(index);

            int nextIndex = index + (input.length() / 2);
            if (nextIndex >= input.length()) {
                nextIndex = nextIndex - input.length();
            }
            char nextChar = input.charAt(nextIndex);

            if (currentChar == nextChar) {
                sumOfHalfwayDigitsMatching += Long.parseLong(String.valueOf(currentChar));
            }
        }

        return sumOfHalfwayDigitsMatching;
    }
}
