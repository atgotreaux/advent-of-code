package com.gotreaux.aoc.puzzles.year2020.day11;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.CharMatrixProvider;
import org.springframework.stereotype.Component;

@Component
public class SeatingSystemPuzzle extends Puzzle {

    public SeatingSystemPuzzle() {
        super(2020, 11);
    }

    @Override
    public PuzzleOutput<Long, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();
        var modelArrivalFunction = new ModelArrivalFunction();

        var current = new Matrix<>(input, new CharMatrixProvider());
        var next = modelArrivalFunction.apply(current);

        while (!current.equals(next)) {
            current = next;
            next = modelArrivalFunction.apply(next);
        }

        var numberOfOccupiedSeats =
                current.stream().filter(cv -> Seat.OCCUPIED.getLabel().equals(cv.value())).count();

        return new PuzzleOutput<>(numberOfOccupiedSeats, 0);
    }
}
