package com.gotreaux.aoc.puzzles.year2016.day6;

import com.gotreaux.aoc.annotations.ShellPuzzle;
import com.gotreaux.aoc.input.InputProvider;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

@ShellPuzzle(year = 2016, day = 6, title = "Signals and Noise")
public class SignalNoisePuzzle extends Puzzle {
    public SignalNoisePuzzle(InputProvider inputProvider) {
        super(inputProvider);
    }

    @Override
    public PuzzleOutput<String, String> solve()
            throws IOException, URISyntaxException, NoSuchElementException {
        List<String> input = getInputProvider().getInputList();
        int length = input.getFirst().length();

        Comparator<Map.Entry<Integer, Long>> mostCommonComparator = Map.Entry.comparingByValue();
        Comparator<Map.Entry<Integer, Long>> leastCommonComparator =
                Map.Entry.comparingByValue(Comparator.reverseOrder());

        StringBuilder mostCommonBuilder = new StringBuilder(length);
        StringBuilder leastCommonBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            mostCommonBuilder.appendCodePoint(getCommonChar(input, i, mostCommonComparator));
            leastCommonBuilder.appendCodePoint(getCommonChar(input, i, leastCommonComparator));
        }

        return new PuzzleOutput<>(mostCommonBuilder.toString(), leastCommonBuilder.toString());
    }

    private static int getCommonChar(
            Collection<String> messages,
            int position,
            Comparator<Map.Entry<Integer, Long>> comparator)
            throws NoSuchElementException {
        return messages.stream()
                .mapToInt(s -> s.codePointAt(position))
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(comparator)
                .orElseThrow()
                .getKey();
    }
}
