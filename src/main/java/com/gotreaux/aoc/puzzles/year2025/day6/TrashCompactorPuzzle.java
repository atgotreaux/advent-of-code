package com.gotreaux.aoc.puzzles.year2025.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class TrashCompactorPuzzle extends Puzzle {

    public TrashCompactorPuzzle() {
        super(2025, 6);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var horizontalWorksheet = HorizontalWorksheet.of(input);

        var rtlVerticalWorksheet = RtlVerticalWorksheet.of(input);

        return new PuzzleOutput<>(
                horizontalWorksheet.getSumOfAnswers(), rtlVerticalWorksheet.getSumOfAnswers());
    }
}
