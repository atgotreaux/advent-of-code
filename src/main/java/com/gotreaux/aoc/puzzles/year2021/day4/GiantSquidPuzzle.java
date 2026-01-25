package com.gotreaux.aoc.puzzles.year2021.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.matrix.Matrix;
import com.gotreaux.aoc.utils.matrix.provider.IntMatrixProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public class GiantSquidPuzzle extends Puzzle {

    public GiantSquidPuzzle() {
        super(2021, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) {
        var input = inputReader.getInputList();

        var numbersDrawn =
                Arrays.stream(input.getFirst().split(",")).mapToInt(Integer::parseInt).toArray();

        Collection<Board> boards = new ArrayList<>();
        var provider = new IntMatrixProvider();
        for (var i = 2; i < input.size(); i += 6) {
            var matrix = new Matrix<>(input.subList(i, i + 5), provider);
            boards.add(new Board(matrix));
        }

        var firstWinningScore = 0;
        var lastWinningScore = 0;
        for (var numberDrawn : numbersDrawn) {
            for (var board : boards.stream().filter(board -> !board.isWinner()).toList()) {
                board.mark(numberDrawn);
                if (board.isWinner()) {
                    var score = numberDrawn * board.getScore();
                    if (firstWinningScore == 0) {
                        firstWinningScore = score;
                    }
                    lastWinningScore = score;
                }
            }
        }

        return new PuzzleOutput<>(firstWinningScore, lastWinningScore);
    }
}
