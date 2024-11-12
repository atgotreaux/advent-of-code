package com.gotreaux.aoc.puzzles.year2021.day4;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GiantSquidPuzzle extends Puzzle {

    public GiantSquidPuzzle() {
        super(2021, 4);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader)
            throws IOException, URISyntaxException {
        List<String> input = inputReader.getInputList();

        int[] numbersDrawn =
                Arrays.stream(input.getFirst().split(",")).mapToInt(Integer::parseInt).toArray();

        Collection<Board> boards = new ArrayList<>();
        for (int i = 2; i < input.size(); i += 6) {
            boards.add(new Board(input.subList(i, i + 5)));
        }

        int firstWinningScore = 0;
        int lastWinningScore = 0;
        for (int numberDrawn : numbersDrawn) {
            for (Board board : boards.stream().filter(board -> !board.isWinner()).toList()) {
                board.mark(numberDrawn);
                if (board.isWinner()) {
                    int score = numberDrawn * board.getScore();
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
