package com.gotreaux.aoc.puzzles.year2020.day3;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.CharMatrixProvider;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TobogganTrajectoryPuzzle extends Puzzle {

    public TobogganTrajectoryPuzzle() {
        super(2020, 3);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var lines = inputReader.getInputList();
        var map = new Matrix<>(lines, new CharMatrixProvider());

        var slope = new Slope(3, 1);
        var treesEncountered = slope.getTreesEncountered(map);

        var slopeCandidates =
                List.of(new Slope(1, 1), new Slope(5, 1), new Slope(7, 1), new Slope(1, 2));

        var productOfSlopeCandidates =
                slopeCandidates.stream()
                        .mapToInt(slopeCandidate -> slopeCandidate.getTreesEncountered(map))
                        .asLongStream()
                        .reduce(1L, Math::multiplyExact);

        return new PuzzleOutput<>(treesEncountered, productOfSlopeCandidates * treesEncountered);
    }
}
