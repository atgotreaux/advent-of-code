package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.CharMatrixProvider;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class LikeAGifForYourYardPuzzle extends Puzzle {

    protected LikeAGifForYourYardPuzzle() {
        super(2015, 18);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var matrix = new Matrix<>(input, new CharMatrixProvider());

        var partOneGrid = new LightGrid(matrix);

        var stuckLights =
                List.of(
                        new Cell(0, 0),
                        new Cell(0, input.getFirst().length() - 1),
                        new Cell(input.size() - 1, 0),
                        new Cell(input.size() - 1, input.getFirst().length() - 1));

        stuckLights.forEach(light -> matrix.set(light, Light.ON.getLabel()));
        var partTwoGrid = new LightGrid(matrix, stuckLights);

        for (var i = 0; i < 100; i++) {
            partOneGrid = partOneGrid.animate();
            partTwoGrid = partTwoGrid.animate();
        }

        return new PuzzleOutput<>(partOneGrid.getLightCount(), partTwoGrid.getLightCount());
    }
}
