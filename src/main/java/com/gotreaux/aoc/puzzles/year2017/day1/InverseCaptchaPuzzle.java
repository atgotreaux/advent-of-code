package com.gotreaux.aoc.puzzles.year2017.day1;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.stereotype.Component;

@Component
public class InverseCaptchaPuzzle extends Puzzle {

    public InverseCaptchaPuzzle() {
        super(2017, 1);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException {
        int sumOfNextDigitsMatching = 0;
        int sumOfHalfwayDigitsMatching = 0;

        String input = inputReader.getInputString();
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
