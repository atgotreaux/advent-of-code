package com.gotreaux.aoc.puzzles.year2020.day3;

import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.CharMatrix;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TobogganTrajectoryPuzzle extends Puzzle {

    public TobogganTrajectoryPuzzle() {
        super(2020, 3);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputProvider inputProvider)
            throws IOException, URISyntaxException {
        List<String> lines = inputProvider.getInputList();
        CharMatrix map = new CharMatrix(lines);

        Slope slope = new Slope(3, 1);
        int treesEncountered = slope.getTreesEncountered(map);

        List<Slope> slopeCandidates =
                List.of(new Slope(1, 1), new Slope(5, 1), new Slope(7, 1), new Slope(1, 2));

        long productOfSlopeCandidates =
                slopeCandidates.stream()
                        .mapToInt(slopeCandidate -> slopeCandidate.getTreesEncountered(map))
                        .asLongStream()
                        .reduce(1L, Math::multiplyExact);

        return new PuzzleOutput<>(treesEncountered, productOfSlopeCandidates * treesEncountered);
    }
}
