package com.gotreaux.aoc.puzzles.year2016.day6;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class SignalNoisePuzzle extends Puzzle {

    public SignalNoisePuzzle() {
        super(2016, 6);
    }

    @Override
    public PuzzleOutput<String, String> solve(InputReader inputReader) {
        var input = inputReader.getInputList();
        var length = input.getFirst().length();

        Comparator<Map.Entry<Integer, Long>> mostCommonComparator = Map.Entry.comparingByValue();
        Comparator<Map.Entry<Integer, Long>> leastCommonComparator =
                Map.Entry.comparingByValue(Comparator.reverseOrder());

        var mostCommonBuilder = new StringBuilder(length);
        var leastCommonBuilder = new StringBuilder(length);
        for (var i = 0; i < length; i++) {
            mostCommonBuilder.appendCodePoint(getCommonChar(input, i, mostCommonComparator));
            leastCommonBuilder.appendCodePoint(getCommonChar(input, i, leastCommonComparator));
        }

        return new PuzzleOutput<>(mostCommonBuilder.toString(), leastCommonBuilder.toString());
    }

    private static int getCommonChar(
            Collection<String> messages,
            int position,
            Comparator<Map.Entry<Integer, Long>> comparator) {
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
