package com.gotreaux.aoc.puzzles.year2021.day6;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ShellPuzzle(year = 2021, day = 6, title = "Lanternfish")
public class LanternfishPuzzle extends Puzzle {
    public LanternfishPuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Long, Long> solve() throws IOException, URISyntaxException {
        Map<Integer, Long> lanternfish =
                Arrays.stream(getInputProvider().getInputString().split(","))
                        .map(Integer::parseInt)
                        .collect(groupingBy(identity(), counting()));

        for (int day = 1; day <= 80; day++) {
            lanternfish = simulate(lanternfish);
        }
        long populationOf80Days = lanternfish.values().stream().reduce(0L, Long::sum);

        for (int day = 81; day <= 256; day++) {
            lanternfish = simulate(lanternfish);
        }
        long populationOf256Days = lanternfish.values().stream().reduce(0L, Long::sum);

        return new PuzzleOutput<>(populationOf80Days, populationOf256Days);
    }

    private static Map<Integer, Long> simulate(Map<Integer, Long> lanternfish) {
        long births = lanternfish.getOrDefault(0, 0L);

        return lanternfish.entrySet().stream()
                .collect(
                        toMap(
                                e -> e.getKey() == 0 ? 6 : e.getKey() - 1,
                                Map.Entry::getValue,
                                Long::sum,
                                () -> new HashMap<>(Map.of(8, births))));
    }
}
