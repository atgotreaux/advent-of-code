package com.gotreaux.aoc.puzzles.year2025.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class PrintingDepartmentPuzzle extends Puzzle {

    public PrintingDepartmentPuzzle() {
        super(2025, 4);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputList();
        var grid = MatrixFactory.ofChars(input);

        Function<Matrix<Character>, Matrix<Character>> removeRolls = new RemoveRollsFunction();

        var nextGrid = removeRolls.apply(grid);
        var totalAccessiblePaperRolls = nextGrid.count(Location.REMOVED_ROLL.getLabel());

        var totalRemovablePaperRolls = totalAccessiblePaperRolls;
        while (!grid.equals(nextGrid)) {
            grid = nextGrid;
            nextGrid = removeRolls.apply(nextGrid);
            totalRemovablePaperRolls += nextGrid.count(Location.REMOVED_ROLL.getLabel());
        }

        return new PuzzleOutput<>(totalAccessiblePaperRolls, totalRemovablePaperRolls);
    }
}
