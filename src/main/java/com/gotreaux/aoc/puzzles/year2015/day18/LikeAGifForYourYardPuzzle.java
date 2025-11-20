package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.awt.Point;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class LikeAGifForYourYardPuzzle extends Puzzle {

    protected LikeAGifForYourYardPuzzle() {
        super(2015, 18);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var stuckLights =
                List.of(
                        new Point(0, 0),
                        new Point(0, input.getFirst().length() - 1),
                        new Point(input.size() - 1, 0),
                        new Point(input.size() - 1, input.getFirst().length() - 1));

        var matrix = MatrixFactory.ofChars(input);

        var partOneGrid = new LightGrid(matrix);
        var partTwoGrid = new LightGrid(matrix, stuckLights);

        for (var i = 0; i < 100; i++) {
            partOneGrid = partOneGrid.animate();
            partTwoGrid = partTwoGrid.animate();
        }

        return new PuzzleOutput<>(partOneGrid.getLightCount(), partTwoGrid.getLightCount());
    }
}
