package com.gotreaux.aoc.puzzles.year2019.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Comparator;
import org.springframework.stereotype.Component;

@Component
public class SpaceImageFormatPuzzle extends Puzzle {

    public SpaceImageFormatPuzzle() {
        super(2019, 8);
    }

    @Override
    public PuzzleOutput<Long, String> solve(InputReader inputReader) {
        var input = inputReader.getInputString();

        var image = Image.of(input, 25, 6);

        var fewestZeroesLayer =
                image.layers().stream()
                        .min(Comparator.comparingLong(layer -> layer.count(Pixel.BLACK.getLabel())))
                        .orElseThrow();

        var productOfFewestZeroes =
                fewestZeroesLayer.count(Pixel.WHITE.getLabel())
                        * fewestZeroesLayer.count(Pixel.TRANSPARENT.getLabel());

        return new PuzzleOutput<>(productOfFewestZeroes, image.render());
    }
}
