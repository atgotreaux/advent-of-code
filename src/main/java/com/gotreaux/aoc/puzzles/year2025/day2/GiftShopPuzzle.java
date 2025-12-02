package com.gotreaux.aoc.puzzles.year2025.day2;

import com.gotreaux.aoc.input.reader.InputReader;
import com.gotreaux.aoc.output.PuzzleOutput;
import com.gotreaux.aoc.puzzles.Puzzle;
import java.util.Arrays;
import java.util.function.LongPredicate;
import org.springframework.stereotype.Component;

@Component
public class GiftShopPuzzle extends Puzzle {

    public GiftShopPuzzle() {
        super(2025, 2);
    }

    @Override
    public PuzzleOutput<Long, Long> solve(InputReader inputReader) {
        var productRanges =
                Arrays.stream(inputReader.getInputString().trim().split(","))
                        .map(ProductRange::of)
                        .toList();

        LongPredicate repeatsExactlyTwice = new SequenceRepeatsExactlyTwice();
        LongPredicate repeatsAtLeastTwice = new SequenceRepeatsAtLeastTwice();

        var sumOfIdsRepeatingTwice =
                productRanges.stream()
                        .flatMap(
                                productRange ->
                                        productRange.findInvalidIds(repeatsExactlyTwice).stream())
                        .mapToLong(Long::longValue)
                        .sum();

        var sumOfIdsRepeatingAtLeastTwice =
                productRanges.stream()
                        .flatMap(
                                productRange ->
                                        productRange.findInvalidIds(repeatsAtLeastTwice).stream())
                        .mapToLong(Long::longValue)
                        .sum();

        return new PuzzleOutput<>(sumOfIdsRepeatingTwice, sumOfIdsRepeatingAtLeastTwice);
    }
}
