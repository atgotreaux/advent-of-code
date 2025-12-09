package com.gotreaux.aoc.puzzles.year2025.day7;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.enums.EnumUtils;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class LaboratoriesPuzzle extends Puzzle {

    public LaboratoriesPuzzle() {
        super(2025, 7);
    }

    @Override
    public PuzzleOutput<Integer, Long> solve(InputReader inputReader) {
        var manifold = MatrixFactory.ofChars(inputReader.getInputList());

        Map<Integer, Long> beamCounts = new HashMap<>();
        var entrance = manifold.find(Space.ENTRANCE.getLabel()).orElseThrow();
        beamCounts.put(entrance.y(), 1L);

        var numberOfBeamSplits = 0;
        for (var row = 1; row < manifold.getRowCount(); row++) {
            Map<Integer, Long> nextBeamCounts = new HashMap<>();
            for (var beamCount : beamCounts.entrySet()) {
                int col = beamCount.getKey();
                long count = beamCount.getValue();

                var space = EnumUtils.of(Space.class, manifold.get(row, col));
                switch (space) {
                    case SPLITTER -> {
                        numberOfBeamSplits++;
                        manifold.neighborCoordinates(
                                        row, col, new Direction[] {Direction.WEST, Direction.EAST})
                                .forEach(
                                        neighbor ->
                                                nextBeamCounts.merge(
                                                        neighbor.y(), count, Long::sum));
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
