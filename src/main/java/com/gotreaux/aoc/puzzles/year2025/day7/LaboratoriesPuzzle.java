package com.gotreaux.aoc.puzzles.year2025.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Cell;
import com.gotreaux.aoc.utils.matrix.CellValue;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.navigator.NeighborsNavigator;
import com.gotreaux.aoc.utils.matrix.provider.CharMatrixProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class LaboratoriesPuzzle extends Puzzle {

    public LaboratoriesPuzzle() {
        super(2025, 7);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var input = inputReader.getInputList();
        var matrix = new Matrix<>(input, new CharMatrixProvider());

        Map<Integer, Long> beamCounts = new HashMap<>();
        var entrance =
                matrix.stream()
                        .filter(cv -> Space.ENTRANCE.getLabel().equals(cv.value()))
                        .map(CellValue::cell)
                        .findFirst()
                        .orElseThrow();
        beamCounts.put(entrance.col(), 1L);

        var numberOfBeamSplits = 0;
        for (var row = 1; row < matrix.getRowCount(); row++) {
            Map<Integer, Long> nextBeamCounts = new HashMap<>();
            for (var beamCount : beamCounts.entrySet()) {
                int col = beamCount.getKey();
                long count = beamCount.getValue();

                var space = EnumUtils.of(Space.class, matrix.get(row, col));
                switch (space) {
                    case SPLITTER -> {
                        numberOfBeamSplits++;
                        var navigator = new NeighborsNavigator<>(matrix, new Cell(row, col));
                        navigator
                                .collectCells(List.of(Direction.WEST, Direction.EAST))
                                .forEach(
                                        neighbor ->
                                                nextBeamCounts.merge(
                                                        neighbor.col(), count, Long::sum));
                    }
                    case EMPTY -> nextBeamCounts.merge(col, count, Long::sum);
                    default -> throw new IllegalStateException("Unexpected space: " + space);
                }
            }
            beamCounts = nextBeamCounts;
        }

        var numberOfTimelines = beamCounts.values().stream().mapToLong(Long::longValue).sum();

        return new PuzzleOutput<>(numberOfBeamSplits, numberOfTimelines);
    }
}
