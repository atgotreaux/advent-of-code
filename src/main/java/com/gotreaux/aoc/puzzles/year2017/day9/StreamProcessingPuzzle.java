package com.gotreaux.aoc.puzzles.year2017.day9;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;

@ShellPuzzle(year = 2017, day = 9, title = "Stream Processing")
public class StreamProcessingPuzzle extends Puzzle {
    public StreamProcessingPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        String input = getInputProvider().getInputString();

        int totalScore = 0;
        int currentScore = 0;
        int garbageCount = 0;
        boolean inGarbage = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (inGarbage) {
                if (c == '!') {
                    i++;
                } else if (c == '>') {
                    inGarbage = false;
                } else {
                    garbageCount++;
                }
            } else {
                if (c == '{') {
                    currentScore++;
                } else if (c == '}') {
                    totalScore += currentScore;
                    currentScore--;
                } else if (c == '<') {
                    inGarbage = true;
                }
            }
        }

        return new PuzzleOutput<>(totalScore, garbageCount);
    }
}
