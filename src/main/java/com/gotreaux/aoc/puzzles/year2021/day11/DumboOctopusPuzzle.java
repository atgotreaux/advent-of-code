package com.gotreaux.aoc.puzzles.year2021.day11;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.DigitMatrixProvider;
import org.springframework.stereotype.Component;

@Component
public class DumboOctopusPuzzle extends Puzzle {

    public DumboOctopusPuzzle() {
        super(2021, 11);
    }

    @Override
    public PuzzleOutput<Long, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var grid = new Matrix<>(input, new DigitMatrixProvider());

        var increaseEnergy = new IncreaseEnergy();

        var totalOctopusFlashes = 0L;
        var step = 0;
        while (step < 100) {
            grid = increaseEnergy.apply(grid);
            totalOctopusFlashes += grid.count(0);
            step++;
        }

        while (!grid.stream().allMatch(cv -> cv.value() == 0)) {
            grid = increaseEnergy.apply(grid);
            step++;
        }

        return new PuzzleOutput<>(totalOctopusFlashes, step);
    }
}
