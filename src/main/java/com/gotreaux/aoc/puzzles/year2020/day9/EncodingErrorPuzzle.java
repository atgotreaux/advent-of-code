package com.gotreaux.aoc.puzzles.year2020.day9;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class EncodingErrorPuzzle extends Puzzle {

    public EncodingErrorPuzzle() {
        super(2020, 9);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var numbers = inputReader.getInputList().stream().map(Long::valueOf).toList();

        var cypher = new Cypher(numbers, 25);

        var invalidNumber = cypher.findInvalidNumber();

        var sumOfContiguousSet = cypher.findContiguousSetSummingTo(invalidNumber);

        return new PuzzleOutput<>(invalidNumber, sumOfContiguousSet);
    }
}
