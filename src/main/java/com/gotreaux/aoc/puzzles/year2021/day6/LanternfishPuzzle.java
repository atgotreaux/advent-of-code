package com.gotreaux.aoc.puzzles.year2021.day6;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.Stream;

@ShellPuzzle(year = 2021, day = 6, title = "Lanternfish")
public class LanternfishPuzzle extends Puzzle {
    public LanternfishPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve() throws IOException, URISyntaxException {
        String input = getInputProvider().getInputString();

        Integer[] lanternfish =
                Arrays.stream(input.split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        for (int day = 1; day <= 80; day++) {
            Integer[] births =
                    Arrays.stream(lanternfish)
                            .filter(i -> i == 0)
                            .map(i -> 8)
                            .toArray(Integer[]::new);

            lanternfish =
                    Arrays.stream(lanternfish).map(i -> i == 0 ? 6 : i - 1).toArray(Integer[]::new);

            lanternfish =
                    Stream.concat(Arrays.stream(lanternfish), Arrays.stream(births))
                            .toArray(Integer[]::new);
        }

        return new PuzzleOutput<>(lanternfish.length, 0);
    }
}
