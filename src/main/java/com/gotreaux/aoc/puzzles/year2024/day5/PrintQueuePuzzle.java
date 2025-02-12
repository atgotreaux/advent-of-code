package com.gotreaux.aoc.puzzles.year2024.day5;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Collection;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class PrintQueuePuzzle extends Puzzle {

    private static final Pattern RULE_PATTERN = Pattern.compile("^\\d+\\|\\d+$");
    private static final Pattern UPDATE_PATTERN = Pattern.compile("^[\\d+,]+\\d+$");

    protected PrintQueuePuzzle() {
        super(2024, 5);
    }

    @Override
    public PuzzleOutput<Integer, Integer> solve(InputReader inputReader) throws Exception {
        Collection<String> input = inputReader.getInputList();

        Collection<PageOrderingRule> rules =
                input.stream()
                        .filter(line -> RULE_PATTERN.matcher(line).matches())
                        .map(PageOrderingRule::of)
                        .toList();

        Collection<PageUpdate> pageUpdates =
                input.stream()
                        .filter(line -> UPDATE_PATTERN.matcher(line).matches())
                        .map(PageUpdate::of)
                        .toList();

        int sumOfCorrectOrders =
                pageUpdates.stream()
                        .filter(update -> update.isCorrectOrder(rules))
                        .mapToInt(update -> update.getMiddlePage(rules))
                        .sum();

        int sumOfIncorrectOrders =
                pageUpdates.stream()
                        .filter(update -> !update.isCorrectOrder(rules))
                        .mapToInt(update -> update.getMiddlePage(rules))
                        .sum();

        return new PuzzleOutput<>(sumOfCorrectOrders, sumOfIncorrectOrders);
    }
}
