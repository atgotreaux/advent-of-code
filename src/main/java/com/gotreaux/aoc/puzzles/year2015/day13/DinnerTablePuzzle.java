package com.gotreaux.aoc.puzzles.year2015.day13;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import com.gotreaux.aoc.utils.CollectionUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ShellPuzzle(year = 2015, day = 13, title = "Knights of the Dinner Table")
public class DinnerTablePuzzle extends Puzzle {
    public DinnerTablePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve()
            throws IOException, URISyntaxException, NoSuchElementException {
        Collection<Arrangement> arrangements =
                getInputProvider()
                        .getInputStream()
                        .map(DinnerTablePuzzle::parseArrangement)
                        .toList();

        List<String> relatives =
                arrangements.stream()
                        .flatMap(
                                arrangement ->
                                        Stream.of(arrangement.relative(), arrangement.neighbor()))
                        .distinct()
                        .toList();

        List<List<String>> permutations = CollectionUtils.permutations(relatives);

        List<Integer> arrangementHappiness =
                permutations.stream()
                        .mapToInt(permutation -> getHappiness(arrangements, permutation))
                        .boxed()
                        .toList();

        int optimalArrangement =
                arrangementHappiness.stream().max(Integer::compareTo).orElseThrow();

        return new PuzzleOutput<>(optimalArrangement, 0);
    }

    private static Arrangement parseArrangement(String line) {
        String[] arrangementParts = line.split(" ");

        String relative = arrangementParts[0];
        String neighbor = arrangementParts[10].replace(".", "");

        int happiness = Integer.parseInt(arrangementParts[3]);
        if (arrangementParts[2].equals("lose")) {
            happiness = -happiness;
        }

        return new Arrangement(relative, neighbor, happiness);
    }

    private static int getHappiness(Collection<Arrangement> arrangements, List<String> permutation)
            throws NoSuchElementException {
        int clockwiseHappiness =
                IntStream.range(0, permutation.size())
                        .mapToObj(
                                i ->
                                        findArrangement(
                                                arrangements,
                                                permutation.get(i),
                                                permutation.get(
                                                        i + 1 == permutation.size() ? 0 : i + 1)))
                        .mapToInt(Arrangement::happiness)
                        .sum();

        int counterClockwiseHappiness =
                IntStream.range(0, permutation.size())
                        .mapToObj(
                                i ->
                                        findArrangement(
                                                arrangements,
                                                permutation.get(i),
                                                permutation.get(
                                                        i == 0 ? permutation.size() - 1 : i - 1)))
                        .mapToInt(Arrangement::happiness)
                        .sum();

        return clockwiseHappiness + counterClockwiseHappiness;
    }

    private static Arrangement findArrangement(
            Collection<Arrangement> arrangements, String relative, String neighbor)
            throws NoSuchElementException {
        return arrangements.stream()
                .filter(arrangement -> arrangement.relative().equals(relative))
                .filter(arrangement -> arrangement.neighbor().equals(neighbor))
                .findFirst()
                .orElseThrow();
    }
}
