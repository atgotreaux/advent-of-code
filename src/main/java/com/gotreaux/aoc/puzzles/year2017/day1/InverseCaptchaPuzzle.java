package com.gotreaux.aoc.puzzles.year2017.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class InverseCaptchaPuzzle extends Puzzle {

    public InverseCaptchaPuzzle() {
        super(2017, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var sumOfNextDigitsMatching = 0;
        var sumOfHalfwayDigitsMatching = 0;

        var input = inputReader.getInputString();
        for (var i = 0; i < input.length(); i++) {
            var currentChar = input.charAt(i);

            var nextChar = i + 1 == input.length() ? input.charAt(0) : input.charAt(i + 1);
            if (currentChar == nextChar) {
                sumOfNextDigitsMatching += Character.digit(currentChar, 10);
            }

            var halfwayIndex = i + (input.length() / 2);
            if (halfwayIndex >= input.length()) {
                halfwayIndex = halfwayIndex - input.length();
            }
            var halfwayChar = input.charAt(halfwayIndex);
            if (currentChar == halfwayChar) {
                sumOfHalfwayDigitsMatching += Character.digit(currentChar, 10);
            }
        }

        return new PuzzleOutput<>(sumOfNextDigitsMatching, sumOfHalfwayDigitsMatching);
    }
}
