package com.gotreaux.aoc.puzzles.year2017.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class StreamProcessingPuzzle extends Puzzle {

    public StreamProcessingPuzzle() {
        super(2017, 9);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputString();

        var totalScore = 0;
        var currentScore = 0;
        var garbageCount = 0;
        var inGarbage = false;

        for (var i = 0; i < input.length(); i++) {
            var c = input.charAt(i);

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
