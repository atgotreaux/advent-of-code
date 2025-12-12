package com.gotreaux.aoc.puzzles.year2024.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Direction;
import com.gotreaux.aoc.utils.matrix.MatrixFactory;
import com.gotreaux.aoc.utils.matrix.Ray;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CeresSearchPuzzle extends Puzzle {

    protected CeresSearchPuzzle() {
        super(2024, 4);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var lines = inputReader.getInputList();

        var mas = List.of('M', 'A', 'S');
        long xmasAppearances = 0, xMasAppearances = 0;

        var matrix = MatrixFactory.ofChars(lines);
        var rowCount = matrix.getRowCount();
        var columnCount = matrix.getColCount();
        for (var row = 0; row < rowCount; row++) {
            for (var col = 0; col < columnCount; col++) {
                char c = matrix.get(row, col);
                if (c == 'X') {
                    xmasAppearances +=
                            Ray.collectElements(matrix, row, col, Direction.allOf(), mas.size())
                                    .values()
                                    .stream()
                                    .filter(list -> list.equals(mas))
                                    .count();
                } else if (c == 'A'
                        && row > 0
                        && row < rowCount - 1
                        && col > 0
                        && col < columnCount - 1) {
                    char nw = matrix.get(row - 1, col - 1);
                    char ne = matrix.get(row - 1, col + 1);
                    char sw = matrix.get(row + 1, col - 1);
                    char se = matrix.get(row + 1, col + 1);
                    if (isCrossPair(nw, se) && isCrossPair(ne, sw)) {
                        xMasAppearances++;
                    }
                }
            }
        }

        return new PuzzleOutput<>(xmasAppearances, xMasAppearances);
    }

    private static boolean isCrossPair(char x, char y) {
        return (x == 'M' && y == 'S') || (x == 'S' && y == 'M');
    }
}
