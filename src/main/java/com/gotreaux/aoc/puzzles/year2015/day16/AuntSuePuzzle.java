package com.gotreaux.aoc.puzzles.year2015.day16;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import org.springframework.stereotype.Component;

@Component
public class AuntSuePuzzle extends Puzzle {

    public AuntSuePuzzle() {
        super(2015, 16);
    }

    @Override
    public PuzzleOutput<?, ?> solve(InputReader inputReader) {
        var aunts = inputReader.getInputStream().map(Aunt::of).toList();

        var mfcsam = new MFCSAM(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);

        var matchingAunt = aunts.stream().filter(mfcsam::matches).findFirst().orElseThrow();
        var matchingRangeAunt =
                aunts.stream().filter(mfcsam::matchesRange).findFirst().orElseThrow();

        return new PuzzleOutput<>(matchingAunt.id(), matchingRangeAunt.id());
    }
}
