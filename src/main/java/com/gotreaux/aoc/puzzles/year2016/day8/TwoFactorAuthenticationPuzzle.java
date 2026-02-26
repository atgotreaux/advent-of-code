package com.gotreaux.aoc.puzzles.year2016.day8;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.puzzles.year2016.day8.operation.OperationFactory;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.CharMatrixProvider;
import java.util.stream.IntStream;
import org.springframework.stereotype.Component;

@Component
public class TwoFactorAuthenticationPuzzle extends Puzzle {

    public TwoFactorAuthenticationPuzzle() {
        super(2016, 8);
    }

    @Override
    public PuzzleOutput<Long, String> solve(InputReader inputReader) {
        var operations = inputReader.getInputStream().map(OperationFactory::of).toList();

        var screen =
                IntStream.range(0, 6)
                        .mapToObj(_ -> String.valueOf(Pixel.OFF.getLabel()).repeat(50))
                        .toList();

        var grid = new Matrix<>(screen, new CharMatrixProvider());

        operations.forEach(operation -> operation.apply(grid));

        var numberOfLitPixels =
                grid.stream().filter(cv -> Pixel.ON.getLabel().equals(cv.value())).count();

        var sb = new StringBuilder(grid.getRowCount() * (grid.getColCount() + 1) + 1);
        sb.append(System.lineSeparator());
        for (var row = 0; row < grid.getRowCount(); row++) {
            for (var col = 0; col < grid.getColCount(); col++) {
                sb.append(grid.get(row, col));
            }
            sb.append(System.lineSeparator());
        }

        return new PuzzleOutput<>(numberOfLitPixels, sb.toString());
    }
}
