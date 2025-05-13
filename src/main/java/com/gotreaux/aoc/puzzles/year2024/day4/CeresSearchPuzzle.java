package com.gotreaux.aoc.puzzles.year2024.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class CeresSearchPuzzle extends Puzzle {

    private static final Character[] MAS = {'M', 'A', 'S'};

    protected CeresSearchPuzzle() {
        super(2024, 4);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) throws Exception {
        var lines = inputReader.getInputList();

        long xmasAppearances = 0, xMasAppearances = 0;

        var matrix = new WordSearchMatrix(lines);
        var rowCount = matrix.getRowCount();
        var columnCount = matrix.getColCount();
        for (var row = 0; row < rowCount; row++) {
            for (var col = 0; col < columnCount; col++) {
                char c = matrix.get(row, col);
                if (c == 'X') {
                    xmasAppearances +=
                            matrix.getWords(row, col, MAS.length).stream()
                                    .filter(array -> Arrays.equals(array, MAS))
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
