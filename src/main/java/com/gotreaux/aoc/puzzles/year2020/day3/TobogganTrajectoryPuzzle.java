package com.gotreaux.aoc.puzzles.year2020.day3;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.CharMatrix;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@ShellPuzzle(year = 2020, day = 3, title = "Toboggan Trajectory")
public class TobogganTrajectoryPuzzle extends Puzzle {
    public TobogganTrajectoryPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve() throws IOException, URISyntaxException {
        List<String> lines = getInputProvider().getInputList();
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
