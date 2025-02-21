package com.gotreaux.aoc.puzzles.year2015.day18;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.awt.Point;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class LikeAGifForYourYardPuzzle extends Puzzle {

    protected LikeAGifForYourYardPuzzle() {
        super(2015, 18);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        List<String> input = inputReader.getInputList();

        List<Point> stuckLights =
                List.of(
                        new Point(0, 0),
                        new Point(0, input.getFirst().length() - 1),
                        new Point(input.size() - 1, 0),
                        new Point(input.size() - 1, input.getFirst().length() - 1));

        LightGridMatrix partOneMatrix = new LightGridMatrix(input);
        LightGridMatrix partTwoMatrix = new LightGridMatrix(input, stuckLights);

        for (int i = 0; i < 100; i++) {
            partOneMatrix = partOneMatrix.animate();
            partTwoMatrix = partTwoMatrix.animate();
        }

        return new PuzzleOutput<>(partOneMatrix.getLightCount(), partTwoMatrix.getLightCount());
    }
}
