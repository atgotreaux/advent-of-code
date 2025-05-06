package com.gotreaux.aoc.puzzles.year2015.day16;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AuntSuePuzzle extends Puzzle {

    public AuntSuePuzzle() {
        super(2015, 16);
    }

    @Override
    public PuzzleOutput<?, ?> solve(InputReader inputReader) throws Exception {
        List<Aunt> aunts = inputReader.getInputStream().map(Aunt::of).toList();

        MFCSAM mfcsam = new MFCSAM(3, 7, 2, 3, 0, 0, 5, 3, 2, 1);

        Aunt matchingAunt = aunts.stream().filter(mfcsam::matches).findFirst().orElseThrow();
        Aunt matchingRangeAunt =
                aunts.stream().filter(mfcsam::matchesRange).findFirst().orElseThrow();

        return new PuzzleOutput<>(matchingAunt.id(), matchingRangeAunt.id());
    }
}
