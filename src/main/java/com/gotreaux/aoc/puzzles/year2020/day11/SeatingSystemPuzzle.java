package com.gotreaux.aoc.puzzles.year2020.day11;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import org.springframework.stereotype.Component;

@Component
public class SeatingSystemPuzzle extends Puzzle {

    public SeatingSystemPuzzle() {
        super(2020, 11);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();
        var modelArrivalFunction = new ModelArrivalFunction();

        var current = MatrixFactory.ofChars(input);
        var next = modelArrivalFunction.apply(current);

        while (!current.equals(next)) {
            current = next;
            next = modelArrivalFunction.apply(next);
        }

        var numberOfOccupiedSeats = Math.toIntExact(current.count(Seat.OCCUPIED.getLabel()));

        return new PuzzleOutput<>(numberOfOccupiedSeats, 0);
    }
}
