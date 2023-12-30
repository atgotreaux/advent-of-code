package com.gotreaux.year2017.day1;

import com.gotreaux.Puzzle;
import com.gotreaux.input.InputProvider;

public class InverseCaptchaPuzzle extends Puzzle {
    public static void main(String[] args) throws Exception {
        InverseCaptchaPuzzle puzzle = new InverseCaptchaPuzzle();

        puzzle.solve();
    }

    public InverseCaptchaPuzzle() {
        super();
    }

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
