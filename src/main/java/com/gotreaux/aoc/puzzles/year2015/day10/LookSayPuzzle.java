package com.gotreaux.aoc.puzzles.year2015.day10;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class LookSayPuzzle extends Puzzle {

    public LookSayPuzzle() {
        super(2015, 10);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var partOne = inputReader.getInputString();

        for (var i = 0; i < 40; i++) {
            partOne = saySequence(partOne);
        }
        var partTwo = partOne;
        for (var i = 0; i < 10; i++) {
            partTwo = saySequence(partTwo);
        }

        return new PuzzleOutput<>(partOne.length(), partTwo.length());
    }

    static String saySequence(CharSequence sequence) {
        var sayBuilder = new StringBuilder(sequence.length());

        var cursor = 0;
        while (cursor < sequence.length()) {
            var occurrences = 1;
            var c = sequence.charAt(cursor);

            while (cursor < sequence.length() - 1 && c == sequence.charAt(cursor + 1)) {
                cursor++;
                occurrences++;
            }

            sayBuilder.append(occurrences).append(c);
            cursor++;
        }

        return sayBuilder.toString();
    }
}
